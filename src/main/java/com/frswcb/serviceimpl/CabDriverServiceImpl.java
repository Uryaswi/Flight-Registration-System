package com.frswcb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.CabDriverDto;
import com.frswcb.entity.CabDriver;
import com.frswcb.entity.Role;
import com.frswcb.exceptions.ResourceNotFoundException;
import com.frswcb.repository.CabDriverRepository;
import com.frswcb.repository.RoleRepository;
import com.frswcb.service.CabDriverService;
import com.frswcb.util.CabDriverConverter;

@Service
public class CabDriverServiceImpl implements CabDriverService {

	@Autowired
	CabDriverRepository cdRepository;
	
	@Autowired
	CabDriverConverter cdConverter;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public CabDriverDto saveCabDriver(CabDriver cabDriver) {
		
		Role role = roleRepository.findById(2).get();
		
		cabDriver.setRole(role);
		
		cdRepository.save(cabDriver);
		
		return cdConverter.convertEntityToCabDriverDto(cabDriver);
	}

	@Override
	public CabDriverDto getCabDrvById(int drvId) throws ResourceNotFoundException {
		CabDriver drv = cdRepository.findById(drvId).orElseThrow(()-> 
		new ResourceNotFoundException("CabDriver","drvId",drvId));
		return cdConverter.convertEntityToCabDriverDto(drv);
	}
	
}
