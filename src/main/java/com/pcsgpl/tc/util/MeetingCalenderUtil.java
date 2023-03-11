package com.pcsgpl.tc.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pcsgpl.tc.dto.OfficeLocationsDTO;
import com.pcsgpl.tc.entity.OfficeLocationsEntity;
import com.pcsgpl.tc.repository.OfficeLocationsRepository;
import com.pcsgpl.tc.service.MeetingCalenderService;

public class MeetingCalenderUtil {
	@Autowired
	private MeetingCalenderService meetingCalenderService;
	
   public List<OfficeLocationsDTO> populateOfficeLocations(){
	   List<OfficeLocationsDTO> officeLocation = meetingCalenderService.populateOfficeLocations();
	   
	   return officeLocation;
	   
   }
}
