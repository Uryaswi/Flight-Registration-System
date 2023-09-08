package com.frswcb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frswcb.dto.CabDriverDto;
import com.frswcb.entity.CabDriver;
import com.frswcb.service.CabDriverService;
import com.frswcb.util.CabDriverConverter;


@RestController
public class CabDriverController {
	
	@Autowired
	CabDriverService cdService;
	@Autowired
	CabDriverConverter cdConverter;
	
	@PostMapping("/saveCabDriver")
	public CabDriverDto saveCabDriver(@Valid @RequestBody  CabDriverDto cabDriverDto) {
		final	CabDriver cabDriver = cdConverter.convertCabDriverDtoToEntity(cabDriverDto);
		return cdService.saveCabDriver(cabDriver);
	
}
	
	@GetMapping("/getCabDriver/{drvId}")
	public CabDriverDto getCabDriverById(@PathVariable("drvId")int drvId)
	{
		return cdService.getCabDrvById(drvId);
	}
}

