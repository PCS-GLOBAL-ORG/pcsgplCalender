package com.pcsgpl.tc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pcsgpl.tc.entity.MeetingCalenderEntity;

@Repository
public interface MeetingCalenderRepository extends JpaRepository<MeetingCalenderEntity,Integer> {
	
	public MeetingCalenderEntity findByMeetingId(String meetingId);
	


}
