package com.pcsgpl.tc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;
import com.pcsgpl.tc.repository.MeetingCalenderRepository;

@Service
public class MeetingCalenderService {
	@Autowired
	MeetingCalenderRepository repository;
	
	
	public MeetingCalenderEntity storeMeetingDeatils(MeetingCalenderEntity meetingCalenderEntity) throws Exception {
		
		
//		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
//		meetingCalenderEntity.setMeetingCategory(meetingCalenderDTO.getMeetingCategory());
//		meetingCalenderEntity.setMeetingOccuranceType(meetingCalenderDTO.getMeetingOccuranceType());
//		Date meetingStartDate=new SimpleDateFormat("yyyy-mm-dd").parse(meetingCalenderDTO.getMeetingStartDate());		
//		meetingCalenderEntity.setMeetingEndDate(meetingStartDate);
//		
//		Date meetingEndDate=new SimpleDateFormat("yyyy-mm-dd").parse(meetingCalenderDTO.getMeetingEndDate());		
//		meetingCalenderEntity.setMeetingEndDate(meetingEndDate);
//		
//		Date setMeetingStartTime=new SimpleDateFormat("HH:mm").parse(meetingCalenderDTO.getMeetingStartTime());
//		meetingCalenderEntity.setMeetingStartTime(setMeetingStartTime);
//		
//		Date setMeetingEndTime=new SimpleDateFormat("HH:mm").parse(meetingCalenderDTO.getMeetingEndDate());
//		meetingCalenderEntity.setMeetingEndTime(setMeetingEndTime);
//		
//		meetingCalenderEntity.setMeetingTitle(meetingCalenderDTO.getMeetingTitle());
//		meetingCalenderEntity.setMeetingShortDesc(meetingCalenderDTO.getMeetingShortDesc());
//		meetingCalenderEntity.setMeetingBranch(meetingCalenderDTO.getMeetingBranch());
//		meetingCalenderEntity.setMeetingId(meetingCalenderDTO.getMeetingId());
//		
		
		
		MeetingCalenderEntity mEETINGCalenderEntity =repository.save(meetingCalenderEntity);
		return mEETINGCalenderEntity;
	}
	
	public List<MeetingCalenderEntity>getAllMeetingCalenderDetails(){
		List<MeetingCalenderEntity> listOfMeetingInformation =repository.findAll();
		return listOfMeetingInformation;
	}
	
}
