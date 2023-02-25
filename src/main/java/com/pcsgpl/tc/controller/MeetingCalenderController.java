package com.pcsgpl.tc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.service.MeetingCalenderService;

@Controller
public class MeetingCalenderController {

	@Autowired
	MeetingCalenderService meetingCalenderServices;
//	@Autowired
//	MeetingCalenderEntity meetingCalenderEntity;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/Schedule-Meeting")
	public String scheduleMeeting() {
		return "calender-registration.jsp";
	}

//	@PostMapping("/addCalenderInfoDetails")
//	public String createCalenderInfoDetails(@ModelAttribute MeetingCalenderEntity meetingCalenderEntity) throws Exception {
//	@RequestMapping(value = "/meeting-registration", method = RequestMethod.POST)
//	public String createCalenderInfoDetails(HttpServletRequest request) throws Exception {
	
	@RequestMapping(value = "/meeting-registration", method = RequestMethod.POST)
	public String createCalenderInfoDetails(@ModelAttribute MeetingCalenderEntity meetingCalenderEntity,HttpServletRequest request) throws Exception {
	
		MeetingCalenderEntity meetingCalender=meetingCalenderServices.storeMeetingDeatils(meetingCalenderEntity);
		
		if(null != meetingCalender) {
		request.setAttribute("message", " <font  style='color:green;font-weight:bold'> Meeting Record Create Successfully </font>");
		}else {
			request.setAttribute("message", "<font  style='color:green'> Meeting Record Creation failed </font>");	
		}
		return "calender-registration.jsp";
	}

}

