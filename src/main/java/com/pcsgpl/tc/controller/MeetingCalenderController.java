package com.pcsgpl.tc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
// import com.pcsgpl.tc.repository.MeetingCalenderRepository;
import com.pcsgpl.tc.service.MeetingCalenderService;

@Controller
public class MeetingCalenderController {

  @Autowired MeetingCalenderService meetingCalenderServices;
  // @Autowired
  // MeetingCalenderRepository repository;

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/login")
  public String login() {
    System.out.println(" Inside.. Controller Login");
    return "login";
  }

  @RequestMapping("/logout-success")
  public String logout() {
    System.out.println(" Inside.. Controller Logout");

    return "login";
  }

  @GetMapping("/Schedule-Meeting")
  public String scheduleMeeting(HttpServletRequest request) {
    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();

    request.setAttribute("officeLocDtos", officeLocDtos);
    return "calender-registration";
  }

  @RequestMapping(value = "/meeting-registration", method = RequestMethod.POST)
  public String createCalenderInfoDetails(
      @ModelAttribute MeetingCalenderEntity meetingCalenderEntity, HttpServletRequest request)
      throws Exception {

    MeetingCalenderEntity meetingCalender =
        meetingCalenderServices.storeMeetingDeatils(meetingCalenderEntity);

    if (null != meetingCalender) {
      request.setAttribute(
          "message",
          " <font  style='color:green;font-weight:bold'> Meeting Record Create Successfully ! </font>");
    } else {
      request.setAttribute(
          "message", "<font  style='color:green'> Meeting Record Creation failed ! </font>");
    }
    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
    request.setAttribute("officeLocDtos", officeLocDtos);
    return "calender-registration";
    // return "meetingCalender";
  }

  @RequestMapping("/GetAllMeetingDetails")
  public String home(
      Model model,
      HttpServletRequest request,
      @RequestParam("page") String page,
      @RequestParam("size") String size) {

    System.out.println("IN GetAllMeetingDetails PAGE: " + page);
    System.out.println("IN GetAllMeetingDetails SIZE: " + size);
    Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
    Page<MeetingCalenderDTO> allMeetings =
        meetingCalenderServices.getAllMeetingCalenderDetails(pageable);

    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
    request.setAttribute("officeLocDtos", officeLocDtos);

    setUpModeldataForView(model, allMeetings,"GetAllMeetingDetails");

    System.out.println(
        "IN GetAllMeetingDetails :: NUMBER -> "
            + allMeetings.getNumber()
            + ", TOTAL PAGES -> "
            + allMeetings.getTotalPages()
            + ", TOTAL ELEMENTS -> "
            + allMeetings.getTotalElements()
            + ", PAGE SIZE -> "
            + allMeetings.getSize()
            + ", ALL CONTENT -> "
            + allMeetings.getContent());
    return "all-meeting-details";
  }

  @RequestMapping(
      value = "/GetMeetingByMeetingId",
      method = RequestMethod.GET,
      params = {"meetingId"})
  public String getMeetingByMeetingId(
      @RequestParam(value = "meetingId", required = true) String meetingId,
      HttpServletRequest request) {
    System.out.println(" Meeting Id : " + meetingId);
    request.setAttribute(
        "calender_info_by_meeting_id",
        meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId));

    return "meeting-details";
  }

  @RequestMapping(value = "/delete-meeting", method = RequestMethod.GET)
  public String deleteMeetingById(
      @RequestParam(value = "meetingId") String meetingId,
      HttpServletRequest request,
      Model model,
      Pageable pageable) {
    System.out.println("Deleted Meeting Id :: " + meetingId);
    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();

    request.setAttribute("officeLocDtos", officeLocDtos);

    boolean returnFlag = meetingCalenderServices.deleteMeeting(meetingId);
    if (returnFlag) {
      request.setAttribute("delete-message", "Record deleted Successfully");
      model.addAttribute(
          "calender_info_detailss", meetingCalenderServices.getAllMeetingCalenderDetails(pageable));
    }

    return "all-meeting-details";
  }

  @RequestMapping(value = "/edit-meeting", method = RequestMethod.GET)
  public String editMeetingById(
      @RequestParam(value = "meetingId") String meetingId, Model model, HttpServletRequest request)
      throws Exception {
    MeetingCalenderDTO getmeet =
        meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId);
    request.setAttribute(
        "calender_info_by_meeting_id",
        meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId));

    System.out.println("EDIT CALENDAR INFO BY MEETING::" + getmeet.getMeetingCategory());
    System.out.println("meetingId in meeting edit" + meetingId);
    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();

    System.out.println("OFFICE LOC DTOs::" + officeLocDtos.toString());
    request.setAttribute("officeLocDtos", officeLocDtos);

    request.setAttribute("meetingId", meetingId);

    return "edit-meeting-details";
  }

  @RequestMapping(value = "/update-meeting", method = RequestMethod.POST)
  public String updateMeetingById(
      @ModelAttribute MeetingCalenderEntity meetingCalenderEntity, HttpServletRequest request) {
    MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();
    String meetingId = request.getParameter("meetingId");

    System.out.println(
        "UPDATE Meeting FROM ServletRequest-> meetingId ::" + request.getParameter("meetingId"));
    System.out.println("update page --->meetingCategory" + request.getParameter("meetingCategory"));

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

    MeetingCalenderDTO updateMeetInfo =
        meetingCalenderServices.updateMeetingDetailsByMeetingId(meetingId, meetingCalenderDTO);
    System.out.println("update title" + updateMeetInfo.getMeetingTitle());
    request.setAttribute("calender_info_by_meeting_id", updateMeetInfo);
    // System.out.println(" Meeting Title  -->  "+
    // meetingCalenderServices.getMeetingCalenderDetailsByMeetingId(meetingId).getMeetingTitle());
    return "meeting-details.jsp";
  }

  @RequestMapping(value = "/search-meeting-by-branch-location", method = RequestMethod.GET)
  public String searchByMeetingBranch(
      Model model,
      HttpServletRequest request,
      @RequestParam("page") String page,
      @RequestParam("size") String size) {
    String meetingBranch = request.getParameter("officelocation");
    if(null == meetingBranch){
      meetingBranch = request.getParameter("branchName");
    }
    System.out.println(
        "In MeetingCalendarController:: Method:: search-meeting-by-branch-loc:: " + meetingBranch);
    System.out.println("IN search-meeting-by-branch-location PAGE: " + page);
    System.out.println("IN search-meeting-by-branch-location SIZE: " + size);
    Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));

    Page<MeetingCalenderDTO> allMeetings =
        meetingCalenderServices.findByMeetingBranchName(meetingBranch, pageable);
    model.addAttribute("calender_info_details", allMeetings);
    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();

    request.setAttribute("officeLocDtos", officeLocDtos);


    model.addAttribute("branchName",meetingBranch);
    setUpModeldataForView(model, allMeetings,"search-meeting-by-branch-location");

    System.out.println(
        "IN search-meeting-by-branch-location :: NUMBER -> "
            + allMeetings.getNumber()
            + ", TOTAL PAGES -> "
            + allMeetings.getTotalPages()
            + ", TOTAL ELEMENTS -> "
            + allMeetings.getTotalElements()
            + ", PAGE SIZE -> "
            + allMeetings.getSize()
            + ", ALL CONTENT -> "
            + allMeetings.getContent());

    return "all-meeting-details";
  }

  @RequestMapping(value = "/search-meeting-by-form-date-to-date", method = RequestMethod.GET)
  public String searchByMeetingDate(
      Model model,
      HttpServletRequest request,
      @RequestParam("page") String page,
      @RequestParam("size") String size) {

    String meetingStartDate = request.getParameter("meetingStartDate");
    String meetingEndDate = request.getParameter("meetingEndDate");
    System.out.println(
        "In MeetingCalendarCOntroller:: Method:: search-meeting-by-form-date-to-date:: "
            + meetingStartDate);
    System.out.println("IN search-meeting-by-form-date-to-date PAGE: " + page);
    System.out.println("IN search-meeting-by-form-date-to-date SIZE: " + size);
    Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
    Page<MeetingCalenderDTO> allMeetings =
        meetingCalenderServices.findByMeetingFormDateToDate(
            meetingStartDate, meetingEndDate, pageable);
    model.addAttribute("calender_info_details", allMeetings);

    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
    request.setAttribute("officeLocDtos", officeLocDtos);

    setUpModeldataForView(model, allMeetings,"search-meeting-by-form-date-to-date");

    System.out.println(
        "IN search-meeting-by-form-date-to-date :: NUMBER -> "
            + allMeetings.getNumber()
            + ", TOTAL PAGES -> "
            + allMeetings.getTotalPages()
            + ", TOTAL ELEMENTS -> "
            + allMeetings.getTotalElements()
            + ", PAGE SIZE -> "
            + allMeetings.getSize()
            + ", ALL CONTENT -> "
            + allMeetings.getContent());

    return "all-meeting-details";
  }

  private static void setUpModeldataForView(Model model, Page<MeetingCalenderDTO> allMeetings, String api) {
    model.addAttribute("number", allMeetings.getNumber());
    model.addAttribute("totalPages", allMeetings.getTotalPages());
    model.addAttribute("totalElements", allMeetings.getTotalElements());
    model.addAttribute("pageSize", allMeetings.getSize());
    model.addAttribute("calender_info_details", allMeetings.getContent());
    model.addAttribute("API",api);
  }

  @GetMapping(value = "/sort-by-location")
  public String sortByMeetingLocation(
      Model model,
      HttpServletRequest request,
      @RequestParam("page") String page,
      @RequestParam("size") String size) {

    String meetingBranch = request.getParameter("officelocation");
    System.out.println("IN sort-by-location PAGE: " + page);
    System.out.println("IN sort-by-location SIZE: " + size);
    Pageable pageable =
        PageRequest.of(
            Integer.valueOf(page),
            Integer.valueOf(size),
            Sort.by(Sort.Direction.ASC, "meetingBranch"));
    Page<MeetingCalenderDTO> allMeetings =
        meetingCalenderServices.findAllMeetingSortedByLocation(meetingBranch, pageable);

    model.addAttribute("calender_info_details", allMeetings);

    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
    request.setAttribute("officeLocDtos", officeLocDtos);

    setUpModeldataForView(model, allMeetings,"sort-by-location");

    System.out.println(
        "IN sort-by-location :: NUMBER -> "
            + allMeetings.getNumber()
            + ", TOTAL PAGES -> "
            + allMeetings.getTotalPages()
            + ", TOTAL ELEMENTS -> "
            + allMeetings.getTotalElements()
            + ", PAGE SIZE -> "
            + allMeetings.getSize()
            + ", ALL CONTENT -> "
            + allMeetings.getContent());

    return "all-meeting-details";
  }

  @GetMapping(value = "/sort-by-date")
  public String sortByMeetingDate(
      Model model,
      HttpServletRequest request,
      @RequestParam("page") String page,
      @RequestParam("size") String size) {

    String meetingBranch = request.getParameter("officelocation");
    String meetingStartDate = request.getParameter("meetingStartDate");

    Pageable pageable =
        PageRequest.of(
            Integer.valueOf(page),
            Integer.valueOf(size),
            Sort.by(Sort.Direction.ASC, "meetingStartDate"));

    Page<MeetingCalenderDTO> allMeetings =
        meetingCalenderServices.findAllMeetingSortedByDate(meetingStartDate, pageable);
    model.addAttribute("calender_info_details", allMeetings);

    List<OfficeLocationsDTO> officeLocDtos = meetingCalenderServices.populateOfficeLocations();
    request.setAttribute("officeLocDtos", officeLocDtos);

    setUpModeldataForView(model, allMeetings,"sort-by-date");

    System.out.println(
        "IN sort-by-date :: NUMBER -> "
            + allMeetings.getNumber()
            + ", TOTAL PAGES -> "
            + allMeetings.getTotalPages()
            + ", TOTAL ELEMENTS -> "
            + allMeetings.getTotalElements()
            + ", PAGE SIZE -> "
            + allMeetings.getSize()
            + ", ALL CONTENT -> "
            + allMeetings.getContent());

    return "all-meeting-details";
  }
}
