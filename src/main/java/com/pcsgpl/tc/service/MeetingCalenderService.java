package com.pcsgpl.tc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.pcsgpl.tc.repository.OfficeLocationsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.dto.OfficeLocationsDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.entity.OfficeLocationsEntity;
import com.pcsgpl.tc.repository.MeetingCalenderRepository;

@Service
public class MeetingCalenderService {
  @Autowired MeetingCalenderRepository meetingCalenderrepository;
  @Autowired OfficeLocationsRepository officeLocationsRepository;

  /* --------------------  Start Store information -------------------------- */

  public MeetingCalenderEntity storeMeetingDeatils(MeetingCalenderEntity meetingCalenderEntity)
      throws Exception {

    //		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());

    MeetingCalenderEntity mEETINGCalenderEntity =
        meetingCalenderrepository.save(meetingCalenderEntity);
    return mEETINGCalenderEntity;
  }

  /* ---------------------- End Store information -------------------------- */

  /* -------------------- Start Get Details Information ------------------------- */

  public Page<MeetingCalenderDTO> getAllMeetingCalenderDetails(Pageable page) {
    Page<MeetingCalenderEntity> listOfMeetingInformation = meetingCalenderrepository.findAll(page);


    Page<MeetingCalenderDTO> listOfModifiedMeetingInfo =
        listOfMeetingInformation.map(
            calenderEntity -> {
              MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();

              if (null != calenderEntity.getMeetingStartDate()) {
                String meetingStartDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
                meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
              }

              if (null != calenderEntity.getMeetingEndDate()) {
                String meetingEndDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
                meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
              }
              
//              if (calenderEntity.getMeetingOccuranceType().equals("M")) {
//         			meetingCalenderDTO.setMeetingOccuranceType("Multiple");
//         		} else if (calenderEntity.getMeetingOccuranceType().equals("S")) {
//         			meetingCalenderDTO.setMeetingOccuranceType("Single");
//         		}

              meetingCalenderDTO.setMeetingCategory(calenderEntity.getMeetingCategory());

              meetingCalenderDTO.setMeetingOccuranceType(calenderEntity.getMeetingOccuranceType());

              meetingCalenderDTO.setMeetingId(calenderEntity.getMeetingId());
              meetingCalenderDTO.setZoomUrl(calenderEntity.getZoomUrl());

              meetingCalenderDTO.setMeetingPasscode(calenderEntity.getMeetingPasscode());
              meetingCalenderDTO.setMeetingStartTime(calenderEntity.getMeetingStartTime());
              meetingCalenderDTO.setMeetingStartMeridiem(calenderEntity.getMeetingStartMeridiem());

              meetingCalenderDTO.setMeetingEndTime(calenderEntity.getMeetingEndTime());
              meetingCalenderDTO.setMeetingEndMeridiem(calenderEntity.getMeetingEndMeridiem());

              meetingCalenderDTO.setMeetingTitle(calenderEntity.getMeetingTitle());
              meetingCalenderDTO.setMeetingShortDesc(calenderEntity.getMeetingShortDesc());

              meetingCalenderDTO.setMeetingBranch(calenderEntity.getMeetingBranch());

              return meetingCalenderDTO;
            });

    return listOfModifiedMeetingInfo;
  }

  /* --------------------End Get Details Information---------------------------- */

  /* -------------------Start Get Meeting Information with MeetingId------------------- */

  public MeetingCalenderDTO getMeetingCalenderDetailsByMeetingId(String meetingId) {
   // MeetingCalenderEntity meetingInformation = meetingCalenderrepository.findByMeetingId(meetingId);


		MeetingCalenderEntity meetingCalenderEntity = meetingCalenderrepository.findByMeetingId(meetingId);
		MeetingCalenderDTO	meetingCalenderDTO = new MeetingCalenderDTO();				
		/*meetingCalenderDTO.setMeetingCategory(meetingInformation.getMeetingCategory());
		*/
		
		meetingCalenderEntity.setMeetingTitle(meetingCalenderDTO.getMeetingTitle());
		meetingCalenderEntity.setMeetingShortDesc(meetingCalenderDTO.getMeetingShortDesc());
		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
		meetingCalenderEntity.setMeetingCategory(meetingCalenderDTO.getMeetingCategory());
		meetingCalenderEntity.setMeetingOccuranceType(meetingCalenderDTO.getMeetingOccuranceType());
		


//		String meetingStartDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingCalenderEntity.setMeetingStartDate());
//		meetingCalenderDTO.getMeetingStartDate(meetingStartDate);
		
		
		MeetingCalenderEntity updatedMeetingCalenderEntity = meetingCalenderrepository.save(meetingCalenderEntity);
				
		meetingCalenderDTO.setMeetingCategory(updatedMeetingCalenderEntity.getMeetingCategory());
		
//		if (meetingCalenderEntity.getMeetingOccuranceType().equals("M")) {
//			meetingCalenderDTO.setMeetingOccuranceType("Multiple");
//		} else if (meetingCalenderEntity.getMeetingOccuranceType().equals("S")) {
//			meetingCalenderDTO.setMeetingOccuranceType("Single");
//		}
		String meetingStartDate1 = new SimpleDateFormat("dd-MM-yyyy").format(updatedMeetingCalenderEntity.getMeetingStartDate());
		meetingCalenderDTO.setMeetingStartDate(meetingStartDate1);
		String meetingEndDate = new SimpleDateFormat("dd-MM-yyyy").format(updatedMeetingCalenderEntity.getMeetingEndDate());
		meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
		meetingCalenderDTO.setMeetingStartTime(updatedMeetingCalenderEntity.getMeetingStartTime());
		meetingCalenderDTO.setMeetingEndTime(updatedMeetingCalenderEntity.getMeetingEndTime());		
		meetingCalenderDTO.setMeetingStartMeridiem(updatedMeetingCalenderEntity.getMeetingStartMeridiem());
		meetingCalenderDTO.setMeetingEndMeridiem(updatedMeetingCalenderEntity.getMeetingEndMeridiem());
		meetingCalenderDTO.setMeetingTitle(updatedMeetingCalenderEntity.getMeetingTitle());
		meetingCalenderDTO.setMeetingShortDesc(updatedMeetingCalenderEntity.getMeetingShortDesc());
		meetingCalenderDTO.setMeetingBranch(updatedMeetingCalenderEntity.getMeetingBranch());
		meetingCalenderDTO.setZoomUrl(updatedMeetingCalenderEntity.getZoomUrl());
		meetingCalenderDTO.setMeetingId(updatedMeetingCalenderEntity.getMeetingId());
		meetingCalenderDTO.setMeetingPasscode(updatedMeetingCalenderEntity.getMeetingPasscode());
		
				
		return meetingCalenderDTO;		
		
		
	 }
	
	/* ---------------------End Update Meeting Information------------------------ */	
	
	/* --------------------Start Get Office location---------------------------- */
	
  public List<OfficeLocationsDTO> populateOfficeLocations() {

	    List<OfficeLocationsEntity> officeLocation = officeLocationsRepository.findAll();
	    List<OfficeLocationsDTO> listOfLocations = new ArrayList<OfficeLocationsDTO>();

	    for (OfficeLocationsEntity locationsEntity : officeLocation) {

	      OfficeLocationsDTO officeLocationsDTO = new OfficeLocationsDTO();

	      officeLocationsDTO.setBranchCode(locationsEntity.getBranchCode());
	      officeLocationsDTO.setBranchName(locationsEntity.getBranchName());

	      listOfLocations.add(officeLocationsDTO);
	    }

	    return listOfLocations;
	  }

  

   
  public MeetingCalenderDTO updateMeetingDetailsByMeetingId(String meetingId, MeetingCalenderDTO meetingCalenderDTO) {

	    MeetingCalenderEntity meetingCalenderEntity =
	        meetingCalenderrepository.findByMeetingId(meetingId);

	    /*meetingCalenderDTO.setMeetingCategory(meetingInformation.getMeetingCategory());
	     */

	    meetingCalenderEntity.setMeetingTitle(meetingCalenderDTO.getMeetingTitle());
	    meetingCalenderEntity.setMeetingShortDesc(meetingCalenderDTO.getMeetingShortDesc());
	    meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
	    meetingCalenderEntity.setMeetingCategory(meetingCalenderDTO.getMeetingCategory());

	    MeetingCalenderEntity updatedMeetingCalenderEntity =
	        meetingCalenderrepository.save(meetingCalenderEntity);

	    meetingCalenderDTO.setMeetingCategory(updatedMeetingCalenderEntity.getMeetingCategory());
	    meetingCalenderDTO.setMeetingOccuranceType(
	        updatedMeetingCalenderEntity.getMeetingOccuranceType());
	    String meetingStartDate1 =
	        new SimpleDateFormat("dd-MM-yyyy")
	            .format(updatedMeetingCalenderEntity.getMeetingStartDate());
	    meetingCalenderDTO.setMeetingStartDate(meetingStartDate1);
	    String meetingEndDate =
	        new SimpleDateFormat("dd-MM-yyyy").format(updatedMeetingCalenderEntity.getMeetingEndDate());
	    meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
	    meetingCalenderDTO.setMeetingStartTime(updatedMeetingCalenderEntity.getMeetingStartTime());
	    meetingCalenderDTO.setMeetingEndTime(updatedMeetingCalenderEntity.getMeetingEndTime());
	    meetingCalenderDTO.setMeetingStartMeridiem(
	        updatedMeetingCalenderEntity.getMeetingStartMeridiem());
	    meetingCalenderDTO.setMeetingEndMeridiem(updatedMeetingCalenderEntity.getMeetingEndMeridiem());
	    meetingCalenderDTO.setMeetingTitle(updatedMeetingCalenderEntity.getMeetingTitle());
	    meetingCalenderDTO.setMeetingShortDesc(updatedMeetingCalenderEntity.getMeetingShortDesc());
	    meetingCalenderDTO.setMeetingBranch(updatedMeetingCalenderEntity.getMeetingBranch());
	    meetingCalenderDTO.setZoomUrl(updatedMeetingCalenderEntity.getZoomUrl());
	    meetingCalenderDTO.setMeetingId(updatedMeetingCalenderEntity.getMeetingId());
	    meetingCalenderDTO.setMeetingPasscode(updatedMeetingCalenderEntity.getMeetingPasscode());

	    return meetingCalenderDTO;
	  }

  /* ---------------End Get Meeting Information with MeetingId--------------- */

  /* ----------------Start Delete Meeting---------------------------- */

  public boolean deleteMeeting(String meetingId) {
    boolean returnFlag = false;
    MeetingCalenderEntity meetingDeletion = meetingCalenderrepository.findByMeetingId(meetingId);
    try {
      meetingCalenderrepository.delete(meetingDeletion);
      returnFlag = true;
    } catch (Exception e) {
      returnFlag = false;
    }
    return returnFlag;
  }

  /* --------------------End Delete Meeting----------------------------- */

  /* -------------------Start Update Meeting Information---------------------- */



  /* ---------------------End Update Meeting Information------------------------ */

  /* --------------------Start Get Office location---------------------------- */



  /*	--------------------------------------------- */

  public Page<MeetingCalenderDTO> findByMeetingBranchName(String meetingBranch, Pageable pageable) {

    System.out.println(" Search Branch Value  ---> " + meetingBranch);
    Page<MeetingCalenderEntity> listOfMeetingInformation =
        meetingCalenderrepository.findByMeetingBranch(meetingBranch, pageable);

    Page<MeetingCalenderDTO> listOfModifiedMeetingInfo =
        listOfMeetingInformation.map(
            calenderEntity -> {
              MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();

              if (null != calenderEntity.getMeetingStartDate()) {
                String meetingStartDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
                meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
              }

              if (null != calenderEntity.getMeetingEndDate()) {
                String meetingEndDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
                meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
              }

              meetingCalenderDTO.setMeetingCategory(calenderEntity.getMeetingCategory());

              meetingCalenderDTO.setMeetingOccuranceType(calenderEntity.getMeetingOccuranceType());

              meetingCalenderDTO.setMeetingId(calenderEntity.getMeetingId());
              meetingCalenderDTO.setZoomUrl(calenderEntity.getZoomUrl());

              meetingCalenderDTO.setMeetingPasscode(calenderEntity.getMeetingPasscode());
              meetingCalenderDTO.setMeetingStartTime(calenderEntity.getMeetingStartTime());
              meetingCalenderDTO.setMeetingStartMeridiem(calenderEntity.getMeetingStartMeridiem());

              meetingCalenderDTO.setMeetingEndTime(calenderEntity.getMeetingEndTime());
              meetingCalenderDTO.setMeetingEndMeridiem(calenderEntity.getMeetingEndMeridiem());

              meetingCalenderDTO.setMeetingTitle(calenderEntity.getMeetingTitle());
              meetingCalenderDTO.setMeetingShortDesc(calenderEntity.getMeetingShortDesc());

              meetingCalenderDTO.setMeetingBranch(calenderEntity.getMeetingBranch());
              return meetingCalenderDTO;
            });

    System.out.println(" Search List size : " + listOfModifiedMeetingInfo.getTotalElements());
    return listOfModifiedMeetingInfo;
  }

  public Page<MeetingCalenderDTO> findByMeetingFormDateToDate(
      String meetingStartDate, String meetingEndDate, Pageable pageable) {
    System.out.println(" Search Start Value  ---> " + meetingStartDate);
    Page<MeetingCalenderEntity> listOfMeetingInformation =
        meetingCalenderrepository.findMeetingByDateRange(
            meetingStartDate, meetingEndDate, pageable);

    if (null != listOfMeetingInformation) {
      System.out.println(
          "Size of List of meeting:: " + listOfMeetingInformation.getTotalElements());
    }
    Page<MeetingCalenderDTO> listOfModifiedMeetingInfo =
        listOfMeetingInformation.map(
            calenderEntity -> {
              MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();

              if (null != calenderEntity.getMeetingStartDate()) {
                String meetingStartDate1 =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
                meetingCalenderDTO.setMeetingStartDate(meetingStartDate1);
              }

              if (null != calenderEntity.getMeetingEndDate()) {
                String meetingEndDate1 =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
                meetingCalenderDTO.setMeetingEndDate(meetingEndDate1);
              }

              meetingCalenderDTO.setMeetingCategory(calenderEntity.getMeetingCategory());

              meetingCalenderDTO.setMeetingOccuranceType(calenderEntity.getMeetingOccuranceType());

              meetingCalenderDTO.setMeetingId(calenderEntity.getMeetingId());
              meetingCalenderDTO.setZoomUrl(calenderEntity.getZoomUrl());

              meetingCalenderDTO.setMeetingPasscode(calenderEntity.getMeetingPasscode());
              meetingCalenderDTO.setMeetingStartTime(calenderEntity.getMeetingStartTime());
              meetingCalenderDTO.setMeetingStartMeridiem(calenderEntity.getMeetingStartMeridiem());

              meetingCalenderDTO.setMeetingEndTime(calenderEntity.getMeetingEndTime());
              meetingCalenderDTO.setMeetingEndMeridiem(calenderEntity.getMeetingEndMeridiem());

              meetingCalenderDTO.setMeetingTitle(calenderEntity.getMeetingTitle());
              meetingCalenderDTO.setMeetingShortDesc(calenderEntity.getMeetingShortDesc());

              meetingCalenderDTO.setMeetingBranch(calenderEntity.getMeetingBranch());
              return meetingCalenderDTO;
            });

    return listOfModifiedMeetingInfo;
  }

  // To be implemented
  public Page<MeetingCalenderDTO> findAllMeetingSortedByLocation(
      String meetingBranch, Pageable pageable) {

    Page<MeetingCalenderEntity> listOfMeetingInformation =
        meetingCalenderrepository.findAll(pageable);
    Page<MeetingCalenderDTO> listOfModifiedMeetingInfo =
        listOfMeetingInformation.map(
            calenderEntity -> {
              MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();

              if (null != calenderEntity.getMeetingStartDate()) {
                String meetingStartDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
                meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
              }

              if (null != calenderEntity.getMeetingEndDate()) {
                String meetingEndDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
                meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
              }

              meetingCalenderDTO.setMeetingCategory(calenderEntity.getMeetingCategory());

              meetingCalenderDTO.setMeetingOccuranceType(calenderEntity.getMeetingOccuranceType());

              meetingCalenderDTO.setMeetingId(calenderEntity.getMeetingId());
              meetingCalenderDTO.setZoomUrl(calenderEntity.getZoomUrl());

              meetingCalenderDTO.setMeetingPasscode(calenderEntity.getMeetingPasscode());
              meetingCalenderDTO.setMeetingStartTime(calenderEntity.getMeetingStartTime());
              meetingCalenderDTO.setMeetingStartMeridiem(calenderEntity.getMeetingStartMeridiem());

              meetingCalenderDTO.setMeetingEndTime(calenderEntity.getMeetingEndTime());
              meetingCalenderDTO.setMeetingEndMeridiem(calenderEntity.getMeetingEndMeridiem());

              meetingCalenderDTO.setMeetingTitle(calenderEntity.getMeetingTitle());
              meetingCalenderDTO.setMeetingShortDesc(calenderEntity.getMeetingShortDesc());

              meetingCalenderDTO.setMeetingBranch(calenderEntity.getMeetingBranch());

              return meetingCalenderDTO;
            });

    return listOfModifiedMeetingInfo;
  }

  public List<MeetingCalenderEntity> findAllMeetingSortedByLocationDesc(String meetingBranch) {
    return meetingCalenderrepository.findAll(Sort.by(Direction.DESC, "meetingBranch"));
  }

  public Page<MeetingCalenderDTO> findAllMeetingSortedByDate(
      String meetingStartDate, Pageable pageable) {

    Page<MeetingCalenderEntity> listOfMeetingInformation =
        meetingCalenderrepository.findAll(pageable);

    Page<MeetingCalenderDTO> listOfModifiedMeetingInfo =
        listOfMeetingInformation.map(
            calenderEntity -> {
              MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();

              if (null != calenderEntity.getMeetingStartDate()) {
                String meetingStartDateModified =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
                meetingCalenderDTO.setMeetingStartDate(meetingStartDateModified);
              }

              if (null != calenderEntity.getMeetingEndDate()) {
                String meetingEndDate =
                    new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
                meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
              }

              meetingCalenderDTO.setMeetingCategory(calenderEntity.getMeetingCategory());

              meetingCalenderDTO.setMeetingOccuranceType(calenderEntity.getMeetingOccuranceType());

              meetingCalenderDTO.setMeetingId(calenderEntity.getMeetingId());
              meetingCalenderDTO.setZoomUrl(calenderEntity.getZoomUrl());

              meetingCalenderDTO.setMeetingPasscode(calenderEntity.getMeetingPasscode());
              meetingCalenderDTO.setMeetingStartTime(calenderEntity.getMeetingStartTime());
              meetingCalenderDTO.setMeetingStartMeridiem(calenderEntity.getMeetingStartMeridiem());

              meetingCalenderDTO.setMeetingEndTime(calenderEntity.getMeetingEndTime());
              meetingCalenderDTO.setMeetingEndMeridiem(calenderEntity.getMeetingEndMeridiem());

              meetingCalenderDTO.setMeetingTitle(calenderEntity.getMeetingTitle());
              meetingCalenderDTO.setMeetingShortDesc(calenderEntity.getMeetingShortDesc());

              meetingCalenderDTO.setMeetingBranch(calenderEntity.getMeetingBranch());

              return meetingCalenderDTO;
            });

    return listOfModifiedMeetingInfo;
  }

  // To be implemented
  public Page<MeetingCalenderEntity> findPagedRecord() {
    return meetingCalenderrepository.findAll(Pageable.ofSize(5));
  }

  Pageable next() {
    return null;
  }

  Pageable previousOrFirst() {
    return null;
  }

  Pageable first() {
    return null;
  }

  Pageable withPage(int pageNumber) {
    return null;
  }

  public int getNoOfRecords() {
    // TODO Auto-generated method stub
    return getNoOfRecords();
  }
}
