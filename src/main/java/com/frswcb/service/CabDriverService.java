package com.frswcb.service;

import com.frswcb.dto.CabDriverDto;
import com.frswcb.entity.CabDriver;
import com.frswcb.exceptions.ResourceNotFoundException;

public interface CabDriverService {
	
	CabDriverDto saveCabDriver(CabDriver cabDriver);
	
	CabDriverDto getCabDrvById(int drvId) throws ResourceNotFoundException;
}
