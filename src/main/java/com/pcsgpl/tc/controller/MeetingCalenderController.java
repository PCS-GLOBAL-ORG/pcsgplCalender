package com.pcsgpl.tc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.dto.OfficeLocationsDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;
//import com.pcsgpl.tc.repository.MeetingCalenderRepository;
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
	
	@RequestMapping(value = "/login")
	public String login() {
		System.out.println( " Inside.. Controller ");
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logout(){
		System.out.println( " Inside Controller ");
		
		return "login.jsp";
	}
	
	@GetMapping("/Schedule-Meeting")
	public String scheduleMeeting(HttpServletRequest request) {
	List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
	         
	     request.setAttribute("officeLocDtos",officeLocDtos);
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
		List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();        
	    request.setAttribute("officeLocDtos",officeLocDtos);
		return "calender-registration.jsp";
		//return "meetingCalender";
	}
		
	@RequestMapping("/GetAllMeetingDetails")
    public String home(Model model,HttpServletRequest request) {
       model.addAttribute("calender_info_detailss", meetingCalenderServices.getAllMeetingCalenderDetails()); 

         List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
         
         request.setAttribute("officeLocDtos",officeLocDtos);
         
         return "all-meeting-details.jsp";
    }
		
	@RequestMapping(value="/GetMeetingByMeetingId" ,method = RequestMethod.GET, params= {"meetingId"})
    public String getMeetingByMeetingId(@RequestParam(value="meetingId", required = true) String meetingId, HttpServletRequest request) {
		System.out.println(" Meeting Id : "+ meetingId);
	    request.setAttribute("calender_info_by_meeting_id", meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId));	     
	   //System.out.println(" Meeting Title  -->  "+ meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId).getMeetingTitle());     
	    return "meeting-details.jsp";
    }
	
	
	@RequestMapping(value="/delete-meeting",method = RequestMethod.GET)	
	public String deleteMeetingById(@RequestParam(value="meetingId") String meetingId,HttpServletRequest request, Model model) {		
		System.out.println("Deleted Meeting Id :: "+ meetingId);
     List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
	         
	  request.setAttribute("officeLocDtos",officeLocDtos);	
		
	  boolean returnFlag= meetingCalenderServices.deleteMeeting(meetingId);	
	  if(returnFlag) {
		  request.setAttribute("delete-message", "Record deleted Successfully");
		  model.addAttribute("calender_info_detailss", meetingCalenderServices.getAllMeetingCalenderDetails());        
	      
	  }
	  
      return "all-meeting-details.jsp";	
	}
	
			
	@RequestMapping(value="/edit-meeting",method = RequestMethod.GET)
	public String editMeetingById(@RequestParam(value="meetingId") String meetingId,Model model,HttpServletRequest request) throws Exception {		
		MeetingCalenderDTO getmeet =meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId);
		request.setAttribute("calender_info_by_meeting_id", meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId));	
		
		System.out.println("EDIT CALENDAR INFO BY MEETING::"+ getmeet.getMeetingCategory());
		System.out.println("meetingId in meeting edit"+meetingId ); 
        List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
 
        System.out.println("OFFICE LOC DTOs::"+ officeLocDtos.toString());
        request.setAttribute("officeLocDtos",officeLocDtos);
        
        request.setAttribute("meetingId", meetingId);
        
		return "edit-meeting-details.jsp";
	}      

	@RequestMapping(value="/update-meeting",method = RequestMethod.POST)
	public String updateMeetingById(@ModelAttribute MeetingCalenderEntity meetingCalenderEntity,HttpServletRequest request) {	
		MeetingCalenderDTO meetingCalenderDTO  = new MeetingCalenderDTO();
        String meetingId = request.getParameter("meetingId");
        
		System.out.println("UPDATE Meeting FROM ServletRequest-> meetingId ::"+ request.getParameter("meetingId"));		
		System.out.println("update page --->meetingCategory"+request.getParameter("meetingCategory"));
		
		meetingCalenderDTO.setMeetingCategory(request.getParameter("meetingCategory"));
		meetingCalenderDTO.setMeetingOccuranceType(request.getParameter("meetingOccuranceType"));
		meetingCalenderDTO.setMeetingStartDate(request.getParameter("meetingStartDate"));
		meetingCalenderDTO.setMeetingEndDate(request.getParameter("meetingEndDate"));
		meetingCalenderDTO.setMeetingStartTime(request.getParameter("meetingStartTime"));
		meetingCalenderDTO.setMeetingStartMeridiem(request.getParameter("meetingStartMeridiem"));
		meetingCalenderDTO.setMeetingEndTime(request.getParameter("meetingEndTime"));
		meetingCalenderDTO.setMeetingEndMeridiem(request.getParameter("meetingEndMeridiem"));
		meetingCalenderDTO.setMeetingTitle(request.getParameter("meetingTitle")); 
		meetingCalenderDTO.setMeetingShortDesc(request.getParameter("meetingShortDesc"));
		meetingCalenderDTO.setMeetingBranch(request.getParameter("meetingBranch"));

	    MeetingCalenderDTO updateMeetInfo = meetingCalenderServices.updateMeetingDetailsByMeetingId(meetingId,meetingCalenderDTO);
	    System.out.println("update title"+updateMeetInfo.getMeetingTitle());
	    request.setAttribute("calender_info_by_meeting_id",updateMeetInfo);	     
	   //System.out.println(" Meeting Title  -->  "+ meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId).getMeetingTitle());     
	    return "meeting-details.jsp";
			
	}
	

	@RequestMapping(value="/search-meeting-by-branch-location",method = RequestMethod.POST)
    public String searchByMeetingBranch(Model model, HttpServletRequest request) {
		String meetingBranch = request.getParameter("officelocation");
		System.out.println("In MeetingCalendarController:: Method:: search-meeting-by-branch-loc:: "+meetingBranch);
        model.addAttribute("calender_info_detailss", meetingCalenderServices.findByMeetingBranchName(meetingBranch));  
        List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
         
        request.setAttribute("officeLocDtos",officeLocDtos);
         
         return "all-meeting-details.jsp";
    }
	
	@RequestMapping(value="/search-meeting-by-form-date-to-date",method = RequestMethod.POST)
    public String searchByMeetingDate(Model model, HttpServletRequest request) {
		
		String meetingStartDate= request.getParameter("meetingStartDate");
		String meetingEndDate= request.getParameter("meetingEndDate");
		System.out.println("In MeetingCalendarCOntroller:: Method:: search-meeting-by-form-date-to-date:: "+ meetingStartDate);
        model.addAttribute("calender_info_detailss", meetingCalenderServices.findByMeetingFormDateToDate(meetingStartDate,meetingEndDate));  
        
        
        List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();         
        request.setAttribute("officeLocDtos",officeLocDtos);
         
        return "all-meeting-details.jsp";
    }
	
	@RequestMapping(value="/sort-by-location",method = RequestMethod.POST)
	public String sortByMeetingLocation(Model model, HttpServletRequest request) {
		
		String meetingBranch = request.getParameter("officelocation");
		//String meetingStartDate = request.getParameter("meetingStartDate");
		
		//System.out.println("MeetingCalendarController:: Sort by branch loc:: "+meetingBranch);

        model.addAttribute("calender_info_detailss", meetingCalenderServices.findAllMeetingSortedByLocation(meetingBranch)); 

       
        List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();         
        request.setAttribute("officeLocDtos",officeLocDtos); 
        
        return "all-meeting-details.jsp";
	
	}
	
	@RequestMapping(value="/sort-by-date",method = RequestMethod.POST)
	public String sortByMeetingDate(Model model, HttpServletRequest request) {
		
		String meetingBranch = request.getParameter("officelocation");
		String meetingStartDate = request.getParameter("meetingStartDate");
					
        model.addAttribute("calender_info_detailss", meetingCalenderServices.findAllMeetingSortedByDate(meetingStartDate)); 
		
       
        List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();         
        request.setAttribute("officeLocDtos",officeLocDtos); 
        
        return "all-meeting-details.jsp";
	
	}
	
	
	
	
	
}

