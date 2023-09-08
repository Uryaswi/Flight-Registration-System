package com.frswcb.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.frswcb.entity.Address;
import com.frswcb.entity.Cab;
import com.frswcb.entity.CabDriver;
import com.frswcb.repository.CabDriverRepository;
import com.frswcb.repository.CabRepository;
import com.frswcb.service.CabDriverService;
import com.frswcb.service.CabService;

@SpringBootTest
class CabServiceTest {
	
	@Autowired
	CabService cabService;
	
	@Autowired
	CabDriverService cdService;
	
	@MockBean
	CabRepository cabRepository;
	
	@MockBean
	CabDriverRepository cdrvRepository;
	
	@Test
	void testAssinCabDriverToCab() {
		CabDriver drv = CabDriver.builder().userName("Uryaswi").userPassword("yry23").
				email("uryaswi@gmail.com").contact("9154213765").build();
		
		Address add = Address.builder().city("Kolkata").fromLocality("Santoshpur").
				toLocality("LakePally").state("West Bengal").sourcePincode(700041).
				destPincode(700044).build();
		Cab cab = Cab.builder().cabNumber("WB0451").destinationTime
				(LocalDateTime.of(2023, 9, 7, 15, 30, 0)).
				arrivalTime(LocalDateTime.of(2023, 9, 7, 16, 30, 0)).noOfSeat(4).totalDriversAlloted(1).
				address(add).build();
		
		Optional<Cab>opCab = Optional.of(cab);
		Mockito.when(cabRepository.findById(cab.getCabId())).thenReturn(opCab);
		Mockito.when(cdrvRepository.findById(drv.getUserId())).thenReturn(Optional.of(drv));
		
		cabService.assignCabDriverToCab(drv.getUserId(), cab.getCabId());
		
		assertEquals(cab.getCabNumber(), cdService.getCabDrvById(drv.getUserId()).getCab().getCabNumber());
	}

}
