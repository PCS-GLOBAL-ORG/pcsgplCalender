package com.pcsgpl.tc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pcsgpl.tc.repository.OfficeLocationsRepository;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pcsgpl.tc.dto.OfficeLocationsDTO;
import com.pcsgpl.tc.entity.OfficeLocationsEntity;

@ExtendWith(MockitoExtension.class)
public class TestMeetingCalenderService {

	@InjectMocks
	private MeetingCalenderService service;
	
	@Mock
	private OfficeLocationsRepository officeLocationRepo;
	
	List<OfficeLocationsEntity> listOfOfficeLoc;

	
	@BeforeAll
	public void initSetUp() {
		
		MockitoAnnotations.openMocks(this);
	      OfficeLocationsEntity entity1 = OfficeLocationsEntity
	      .builder()
	      .id(1)
	      .branchCode("KOL")
	      .branchName("Kolkata")
	      .build();
	      
	      OfficeLocationsEntity entity2 = OfficeLocationsEntity
	    		  .builder()
	    		  .id(2)
	    		  .branchCode("BLR1")
	    		  .branchName("Mahadevpura")
	    		  .build();
	      
	      List<OfficeLocationsEntity> listOfOfficeLoc = new ArrayList<OfficeLocationsEntity>();
	      listOfOfficeLoc.add(entity1);
	      listOfOfficeLoc.add(entity2);
	}
	
	@Test
    public void testPopulateOfficeLocations() {
		
		when(officeLocationRepo.findAll()).thenReturn(listOfOfficeLoc);
		
    	List<OfficeLocationsDTO> officeLocDtos = service.populateOfficeLocations();
    	
        assertEquals(2,officeLocDtos.size());
    }
}
