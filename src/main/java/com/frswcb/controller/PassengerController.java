package com.frswcb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frswcb.dto.PassengerDto;
import com.frswcb.entity.Passenger;
import com.frswcb.service.PassengerService;
import com.frswcb.util.PassengerConverter;

@RestController
public class PassengerController {
	@Autowired
	PassengerService passService;
	
	@Autowired
	PassengerConverter passConverter;
	
	@PostMapping("/createPassenger")
	public String createPassenger(@Valid @RequestBody PassengerDto passDto)
	{
		final Passenger passenger = passConverter.convertPassengerDtoToEntity(passDto);
		return passService.createPassenger(passenger);
		
	}
	@PostMapping("/savePassenger")
	public PassengerDto savePassenger(@Valid @RequestBody PassengerDto passDto)
	{
		final Passenger passenger = passConverter.convertPassengerDtoToEntity(passDto);
		return passService.savePassenger(passenger);
		
	}
}
