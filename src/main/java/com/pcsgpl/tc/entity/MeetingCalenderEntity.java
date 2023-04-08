package com.pcsgpl.tc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "calender_info_details")
public class MeetingCalenderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "meeting_id")
	private String meetingId;

	@Column(name = "meeting_category")
	private String meetingCategory;

	@Column(name = "meeting_occurance_type")
	private String meetingOccuranceType;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "meeting_start_date")
	private Date meetingStartDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "meeting_end_date")
	private Date meetingEndDate;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "meeting_start_time")
	private String meetingStartTime;
	
	@Column(name = "meeting_start_meridiem")
	private String meetingStartMeridiem;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "meeting_end_time")
	private String meetingEndTime;

	@Column(name = "meeting_end_meridiem")
	private String meetingEndMeridiem;
	
	@Column(name = "meeting_title")
	private String meetingTitle;

	@Column(name = "meeting_short_description")
	private String meetingShortDesc;

	@Column(name = "branch_name")
	private String meetingBranch;

	@Column(name = "meeting_passcode")
	private String meetingPasscode;

	@Column(name = "zoom_Url")
	private String zoomUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingCategory() {
		return meetingCategory;
	}

	public void setMeetingCategory(String meetingCategory) {
		this.meetingCategory = meetingCategory;
	}

	public String getMeetingOccuranceType() {
		return meetingOccuranceType;
	}

	public void setMeetingOccuranceType(String meetingOccuranceType) {
		this.meetingOccuranceType = meetingOccuranceType;
	}

	public Date getMeetingStartDate() {
		return meetingStartDate;
	}

	public void setMeetingStartDate(Date meetingStartDate) {
		this.meetingStartDate = meetingStartDate;
	}

	public Date getMeetingEndDate() {
		return meetingEndDate;
	}

	public void setMeetingEndDate(Date meetingEndDate) {
		this.meetingEndDate = meetingEndDate;
	}

	public String getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(String meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public String getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(String meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	public String getMeetingShortDesc() {
		return meetingShortDesc;
	}

	public void setMeetingShortDesc(String meetingShortDesc) {
		this.meetingShortDesc = meetingShortDesc;
	}

	public String getMeetingBranch() {
		return meetingBranch;
	}

	public void setMeetingBranch(String meetingBranch) {
		this.meetingBranch = meetingBranch;
	}

	public String getMeetingPasscode() {
		return meetingPasscode;
	}

	public void setMeetingPasscode(String meetingPasscode) {
		this.meetingPasscode = meetingPasscode;
	}

	public String getZoomUrl() {
		return zoomUrl;
	}

	public void setZoomUrl(String zoomUrl) {
		this.zoomUrl = zoomUrl;
	}
	

	public String getMeetingStartMeridiem() {
		return meetingStartMeridiem;
	}

	public void setMeetingStartMeridiem(String meetingStartMeridiem) {
		this.meetingStartMeridiem = meetingStartMeridiem;
	}

	public String getMeetingEndMeridiem() {
		return meetingEndMeridiem;
	}

	public void setMeetingEndMeridiem(String meetingEndMeridiem) {
		this.meetingEndMeridiem = meetingEndMeridiem;
	}

	@Override
	public String toString() {
		return "MeetingCalenderEntity [id=" + id + ", meetingId=" + meetingId + ", meetingCategory=" + meetingCategory
				+ ", meetingOccuranceType=" + meetingOccuranceType + ", meetingStartDate=" + meetingStartDate
				+ ", meetingEndDate=" + meetingEndDate + ", meetingStartTime=" + meetingStartTime + ", meetingEndTime="
				+ meetingEndTime + ", meetingTitle=" + meetingTitle + ", meetingShortDesc=" + meetingShortDesc
				+ ", meetingBranch=" + meetingBranch + ", meetingPasscode=" + meetingPasscode + ", zoomUrl=" + zoomUrl
				+ "]";
	}


}