package com.pcsgpl.tc.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcsgpl.tc.dto.MeetingCalenderDTO;
//import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.repository.MeetingCalenderRepository;

@Service
public class MeetingCalenderService {
	@Autowired
	MeetingCalenderRepository repository;
	//@Autowired
	//MeetingCalenderDTO meetingCalenderDTO;
	
	
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
				
		MeetingCalenderEntity mEETINGCalenderEntity = repository.save(meetingCalenderEntity);
		return mEETINGCalenderEntity;
	}
	
	public List<MeetingCalenderDTO> getAllMeetingCalenderDetails(){
		List<MeetingCalenderEntity> listOfMeetingInformation = repository.findAll();
		
		List<MeetingCalenderDTO> listOfModifiedMeetingInfo = new ArrayList<MeetingCalenderDTO>();
		
		for(MeetingCalenderEntity calenderEntity : listOfMeetingInformation) {
			MeetingCalenderDTO meetingCalenderDTO = new MeetingCalenderDTO();
			String meetingStartDate =new SimpleDateFormat("dd-mm-yyyy").format(calenderEntity.getMeetingStartDate());
			meetingCalenderDTO.setMeetingStartDate(meetingStartDate);	
					
			String meetingEndDate =new SimpleDateFormat("dd-mm-yyyy").format(calenderEntity.getMeetingEndDate());
			
			meetingCalenderDTO.setMeetingEndDate(meetingEndDate);	
			listOfModifiedMeetingInfo.add(meetingCalenderDTO);
			
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
		}
		
		
		
		return listOfModifiedMeetingInfo;
	}
	
	public MeetingCalenderDTO getMeetingCalenderDetailsByMeetingId(String meetingId){
		MeetingCalenderEntity meetingInformation = repository.findByMeetingId(meetingId);
		
		
		System.out.println(meetingInformation.getMeetingTitle());
		
		MeetingCalenderDTO meetingCalenderDTO  = new MeetingCalenderDTO();
		if (meetingInformation.getMeetingOccuranceType().equals("M")) {
		meetingCalenderDTO.setMeetingOccuranceType("Multiple");
		}else if(meetingInformation.getMeetingOccuranceType().equals("S")) {
			meetingCalenderDTO.setMeetingOccuranceType("Single");
		}
		meetingCalenderDTO.setMeetingTitle(meetingInformation.getMeetingTitle());
		
		return meetingCalenderDTO;
	}
	
}
