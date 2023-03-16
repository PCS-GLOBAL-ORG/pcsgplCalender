package com.pcsgpl.tc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import com.pcsgpl.tc.repository.OfficeLocationsRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.dto.OfficeLocationsDTO;
//import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.entity.OfficeLocationsEntity;
import com.pcsgpl.tc.repository.MeetingCalenderRepository;


@Service
public class MeetingCalenderService {
	@Autowired
	MeetingCalenderRepository meetingCalenderrepository;
	@Autowired
	OfficeLocationsRepository officeLocationsRepository;

	/* ***********************************  Start Store information ********************************************* */
	
	public MeetingCalenderEntity storeMeetingDeatils(MeetingCalenderEntity meetingCalenderEntity) throws Exception {

//		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
//		meetingCalenderEntity.setMeetingCategory(meetingCalenderDTO.getMeetingCategory());
//		meetingCalenderEntity.setMeetingOccuranceType(meetingCalenderDTO.getMeetingOccuranceType());
//		Date meetingStartDate=new SimpleDateFormat("yyyy-mm-dd").parse(meetingCalenderDTO.getMeetingStartDate());		
//		meetingCalenderEntity.setMeetingEndDate(meetingStartDate);		
//		meetingCalenderEntity.setMeetingTitle(meetingCalenderDTO.getMeetingTitle());
//		meetingCalenderEntity.setMeetingShortDesc(meetingCalenderDTO.getMeetingShortDesc());
//		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
//		meetingCalenderEntity.setMeetingId(meetingCalenderDTO.getMeetingId());
//		

		MeetingCalenderEntity mEETINGCalenderEntity = meetingCalenderrepository.save(meetingCalenderEntity);
		return mEETINGCalenderEntity;
	}

/* *************************** End Store information *********************************** */	
	
/* **************************** Start Get Details Information ************************************** */	
	
	public List<MeetingCalenderDTO> getAllMeetingCalenderDetails() {
		List<MeetingCalenderEntity> listOfMeetingInformation = meetingCalenderrepository.findAll();

		List<MeetingCalenderDTO> listOfModifiedMeetingInfo = new ArrayList<MeetingCalenderDTO>();

		for (MeetingCalenderEntity calenderEntity : listOfMeetingInformation) {
			MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();
			
			if(null != calenderEntity.getMeetingStartDate()) {
			String meetingStartDate = new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingStartDate());
			meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
			}
			
           if(null != calenderEntity.getMeetingEndDate()) {  
			String meetingEndDate = new SimpleDateFormat("dd-MM-yyyy").format(calenderEntity.getMeetingEndDate());
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
			listOfModifiedMeetingInfo.add(meetingCalenderDTO);
		}  

		return listOfModifiedMeetingInfo;
	}

	/* *****************************End Get Details Information *********************************** */
	
	/* ***************************** Start Get Meeting Information with MeetingId ************************************* */
	
	public MeetingCalenderDTO getMeetingCalenderDetailsByMeetingId(String meetingId) {
		MeetingCalenderEntity meetingInformation = meetingCalenderrepository.findByMeetingId(meetingId);

		System.out.println(meetingInformation.getMeetingTitle());

		MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();
		
		meetingCalenderDTO.setMeetingCategory(meetingInformation.getMeetingCategory());
		
		if (meetingInformation.getMeetingOccuranceType().equals("M")) {
			meetingCalenderDTO.setMeetingOccuranceType("Multiple");
		} else if (meetingInformation.getMeetingOccuranceType().equals("S")) {
			meetingCalenderDTO.setMeetingOccuranceType("Single");
		}

		String meetingStartDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingStartDate());
		meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
		String meetingEndDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingEndDate());
		meetingCalenderDTO.setMeetingEndDate(meetingEndDate);

		//meetingCalenderDTO.setMeetingStartTime(meetingInformation.getMeetingStartTime() + meetingInformation.getMeetingStartMeridiem());
		//meetingCalenderDTO.setMeetingEndTime(meetingInformation.getMeetingEndTime() + meetingInformation.getMeetingEndMeridiem());

		meetingCalenderDTO.setMeetingStartTime(meetingInformation.getMeetingStartTime());
		meetingCalenderDTO.setMeetingEndTime(meetingInformation.getMeetingEndTime());
		
		meetingCalenderDTO.setMeetingStartMeridiem(meetingInformation.getMeetingStartMeridiem());
		meetingCalenderDTO.setMeetingEndMeridiem(meetingInformation.getMeetingEndMeridiem());
		
		meetingCalenderDTO.setMeetingTitle(meetingInformation.getMeetingTitle());
		meetingCalenderDTO.setMeetingShortDesc(meetingInformation.getMeetingShortDesc());
		meetingCalenderDTO.setZoomUrl(meetingInformation.getZoomUrl());
		meetingCalenderDTO.setMeetingPasscode(meetingInformation.getMeetingPasscode());
		meetingCalenderDTO.setMeetingId(meetingInformation.getMeetingId());
		meetingCalenderDTO.setMeetingBranch(meetingInformation.getMeetingBranch());

		return meetingCalenderDTO;
	}

	/* *************************** End Get Meeting Information with MeetingId ******************************* */
		
	/* ************************* Start Delete Meeting ********************************* */
	
	public boolean deleteMeeting(String meetingId) {
		boolean returnFlag = false;
		// MeetingCalenderEntity meetingCalenderEntity = repository.findById(id).get();
		MeetingCalenderEntity meetingDeletion = meetingCalenderrepository.findByMeetingId(meetingId);
		// System.out.println(meetingCalenderEntity.getId());
		
		try {
			meetingCalenderrepository.delete(meetingDeletion);
		returnFlag= true;
		}catch(Exception e) {
			returnFlag= false;
		}
		return returnFlag;
	}
	
	/* *************************** End Delete Meeting ********************************** */	

	/* **************************  Start Update Meeting Information  ********************************** */
		
	public MeetingCalenderDTO updateMeetingDetailsByMeetingId(String meetingId,MeetingCalenderDTO meetingCalenderDTO ) {

		/*
		 * boolean returnFlag1 = false;
		 * 
		 * MeetingCalenderEntity meetingEdit =
		 * meetingCalenderrepository.findByMeetingId(meetingId);
		 * if(meetingId.equals(meetingEdit)){
		 * meetingCalenderrepository.save(meetingEdit); returnFlag1 = true; }else {
		 * returnFlag1 = false; }
		 * 
		 * return returnFlag1;
		 */
		MeetingCalenderEntity meetingInformation = meetingCalenderrepository.findByMeetingId(meetingId);

	//	System.out.println(meetingInformation.getMeetingTitle());
		
//		meetingCalenderDTO.setMeetingCategory(meetingInformation.getMeetingCategory());
//		meetingCalenderDTO.setMeetingOccuranceType(meetingInformation.getMeetingOccuranceType());
//       
//		String meetingStartDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingStartDate());
//		meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
//		String meetingEndDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingEndDate());
//		meetingCalenderDTO.setMeetingEndDate(meetingEndDate);		
//		meetingCalenderDTO.setMeetingStartTime(meetingInformation.getMeetingStartTime());
//		meetingCalenderDTO.setMeetingEndTime(meetingInformation.getMeetingEndTime());
//		
//		meetingCalenderDTO.setMeetingStartMeridiem(meetingInformation.getMeetingStartMeridiem());
//		meetingCalenderDTO.setMeetingEndMeridiem(meetingInformation.getMeetingEndMeridiem());
		
		meetingCalenderDTO.setMeetingCategory(meetingInformation.getMeetingCategory());
		meetingCalenderDTO.setMeetingTitle(meetingInformation.getMeetingTitle());
		meetingCalenderDTO.setMeetingShortDesc(meetingInformation.getMeetingShortDesc());
		
		MeetingCalenderEntity updatedMeetingCalenderEntity = meetingCalenderrepository.save(meetingInformation);
		
		
		meetingCalenderDTO.setMeetingCategory(updatedMeetingCalenderEntity.getMeetingCategory());
		
				
		return meetingCalenderDTO;		
		
		
	 }
	
	/*	********************* End Update Meeting Information ****************************  */	
	
	/* ************************  Start Get Office location ********************************* */
	
	public List<OfficeLocationsDTO> populateOfficeLocations(){
		
		   List<OfficeLocationsEntity> officeLocation = officeLocationsRepository.findAll();
		   List<OfficeLocationsDTO> listOfLocations = new ArrayList<OfficeLocationsDTO>();
		   
		   for(OfficeLocationsEntity locationsEntity :officeLocation) {
			   
			   OfficeLocationsDTO officeLocationsDTO  = new OfficeLocationsDTO();
			   
			   officeLocationsDTO.setBranchCode(locationsEntity.getBranchCode());
			   officeLocationsDTO.setBranchName(locationsEntity.getBranchName());

			   listOfLocations.add(officeLocationsDTO);
		   }
		   
		   return listOfLocations;
		   
	   }
	
	/* ********************    End Get office locations  **************************** */
	
	
//	public MeetingCalenderEntity storeMeetingUpdateDeatils(MeetingCalenderEntity meetingCalenderEntity,String meetingId) throws Exception {
//
//		MeetingCalenderEntity meetingInformation2=meetingCalenderrepository.findByMeetingId(meetingId);
//		
//		meetingInformation2.setMeetingCategory(meetingCalenderEntity.getMeetingCategory());
//		meetingInformation2.setMeetingShortDesc(meetingCalenderEntity.getMeetingShortDesc());
//		
//		MeetingCalenderEntity meetingCalenderEntity3 =meetingCalenderrepository.save(meetingInformation2);
//		
//		return meetingCalenderEntity3;
//	}
	

}
