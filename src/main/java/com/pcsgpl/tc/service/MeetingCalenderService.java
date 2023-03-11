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

	public MeetingCalenderEntity updateMeetingDetailsByMeetingId(MeetingCalenderEntity meetingCalenderEntity,String meetingId) {
//	public MeetingCalenderDTO updateMeetingDetailsByMeetingId(String meetingId) {
//		MeetingCalenderEntity meetingInformation = repository.findByMeetingId(meetingId);
//		MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();
//	
//		String meetingStartDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingStartDate());
//		meetingCalenderDTO.setMeetingStartDate(meetingStartDate);
//		String meetingEndDate = new SimpleDateFormat("dd-MM-yyyy").format(meetingInformation.getMeetingEndDate());
//		meetingCalenderDTO.setMeetingEndDate(meetingEndDate);
//		
//		meetingCalenderDTO.setMeetingStartTime(meetingInformation.getMeetingStartTime()); 
//		meetingCalenderDTO.setMeetingStartMeridiem(meetingInformation.getMeetingStartMeridiem());
//		meetingCalenderDTO.setMeetingEndTime(meetingInformation.getMeetingEndTime());
//		meetingCalenderDTO.setMeetingEndMeridiem(meetingInformation.getMeetingEndMeridiem());
//		
//		meetingCalenderDTO.setMeetingTitle(meetingInformation.getMeetingTitle());
//		meetingCalenderDTO.setMeetingShortDesc(meetingInformation.getMeetingShortDesc());
//		meetingCalenderDTO.setZoomUrl(meetingInformation.getZoomUrl());
//		meetingCalenderDTO.setMeetingPasscode(meetingInformation.getMeetingPasscode());
//		meetingCalenderDTO.setMeetingId(meetingInformation.getMeetingId());
//		meetingCalenderDTO.setMeetingBranch(meetingInformation.getMeetingBranch());
//
//		MeetingCalenderDTO meetingCalenderDTO2 = repository.save(meetingCalenderDTO);
//		
//		return meetingCalenderDTO2;
	
		MeetingCalenderEntity mEETINGCalenderEntity = meetingCalenderrepository.save(meetingCalenderEntity);
		return mEETINGCalenderEntity;	
		
	 }
	
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

}
