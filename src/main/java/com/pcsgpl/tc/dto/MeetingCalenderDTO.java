package com.pcsgpl.tc.dto;

import java.io.Serializable;
import java.util.Date;

public class MeetingCalenderDTO implements Serializable {

	private int id;
	private String meetingId;
	private String meetingCategory;
	private String meetingOccuranceType;
	private String meetingStartDate;
	private String meetingEndDate;
	private String meetingStartTime;
	private String meetingEndTime;
	private String meetingTitle;
	private String meetingShortDesc;
	private String meetingBranch;
	
	private String zoomUrl;
	private String meetingPasscode;
	private String meetingStartMeridiem;
	private String meetingEndMeridiem;
	
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
	public String getMeetingStartDate() {
		return meetingStartDate;
	}
	public void setMeetingStartDate(String meetingStartDate) {
		this.meetingStartDate = meetingStartDate;
	}
	public String getMeetingEndDate() {
		return meetingEndDate;
	}
	public void setMeetingEndDate(String meetingEndDate) {
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
	public String getZoomUrl() {
		return zoomUrl;
	}
	public void setZoomUrl(String zoomUrl) {
		this.zoomUrl = zoomUrl;
	}
	public String getMeetingPasscode() {
		return meetingPasscode;
	}
	public void setMeetingPasscode(String meetingPasscode) {
		this.meetingPasscode = meetingPasscode;
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
	
	

}
