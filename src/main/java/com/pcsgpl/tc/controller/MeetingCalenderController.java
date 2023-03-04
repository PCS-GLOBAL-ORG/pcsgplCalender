package com.pcsgpl.tc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.repository.MeetingCalenderRepository;
import com.pcsgpl.tc.service.MeetingCalenderService;

@Controller
public class MeetingCalenderController {

	@Autowired
	MeetingCalenderService meetingCalenderServices;
	@Autowired
	//MeetingCalenderRepository repository;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/Schedule-Meeting")
	public String scheduleMeeting() {
		return "calender-registration.jsp";
	}
	
	@RequestMapping(value = "/meeting-registration", method = RequestMethod.POST)
	public String createCalenderInfoDetails(@ModelAttribute MeetingCalenderEntity meetingCalenderEntity,HttpServletRequest request) throws Exception {
	
		MeetingCalenderEntity meetingCalender=meetingCalenderServices.storeMeetingDeatils(meetingCalenderEntity);
		
		if(null != meetingCalender) {
		request.setAttribute("message", " <font  style='color:green;font-weight:bold'> Meeting Record Create Successfully ! </font>");
		}else {
			request.setAttribute("message", "<font  style='color:green'> Meeting Record Creation failed ! </font>");	
		}
		return "calender-registration.jsp";
	}
	
//	@RequestMapping(value ="/GetAllMeetingDetails", method = RequestMethod.GET)
//	public String getAllMeetingCalenderServiceDetails(@ModelAttribute MeetingCalenderEntity meetingCalenderEntity){	
//		List<MeetingCalenderEntity> listOfMeetingInfo = meetingCalenderServices.getAllMeetingCalenderDetails();
////		return listOfMeetingInfo;
//		
//		//MeetingCalenderEntity meetingCalenderEntitys  = new MeetingCalenderEntity();
//		//meetingCalenderEntity.addObject("meetingCalenderEntitys", meetingCalenderEntitys);
//		//meetingCalenderEntity.put("products", meetingCalenderServices.getAllMeetingCalenderDetails());
//		return "all-meeting-details.jsp";
//	}
//	
	@RequestMapping("/GetAllMeetingDetails")
    public String home(Model model) {
         model.addAttribute("calender_info_detailss", meetingCalenderServices.getAllMeetingCalenderDetails());        
         return "all-meeting-details.jsp";
    }
	//@RequestMapping(value="/GetMeetingByMeetingId" method = RequestMethod.GET, params = {"meetingId"})
	
	@RequestMapping(value="/GetMeetingByMeetingId" ,method = RequestMethod.GET, params= {"meetingId"})
    public String getMeetingByMeetingId(@RequestParam(value="meetingId", required = true) String meetingId, HttpServletRequest request) {
		System.out.println(" Meeting Id : "+ meetingId);
	     request.setAttribute("calender_info_by_meeting_id", meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId));
	     
	//     System.out.println(" Meeting Title  -->  "+ meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId).getMeetingTitle());
      
	     return "meeting-details.jsp";
    }
	
	
	
}

