package com.pcsgpl.tc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pcsgpl.tc.dto.MeetingCalenderDTO;
import com.pcsgpl.tc.entity.MeetingCalenderEntity;

@Repository
public interface MeetingCalenderRepository extends JpaRepository<MeetingCalenderEntity, Integer> {

  public MeetingCalenderEntity findByMeetingId(String meetingId);

  public Page<MeetingCalenderEntity> findByMeetingBranch(String meetingBranch, Pageable pageable);

  @Query(
      value =
          "select * from calender_info_details c where c.meeting_start_date>=:meetingStartDate and c.meeting_end_date<=:meetingEndDate",
      nativeQuery = true)
  public Page<MeetingCalenderEntity> findMeetingByDateRange(
      @Param("meetingStartDate") String meetingStartDate,
      @Param("meetingEndDate") String meetingEndDate,
      Pageable pageable);
}
