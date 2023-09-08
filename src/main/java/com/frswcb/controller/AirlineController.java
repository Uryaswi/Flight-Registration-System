package com.frswcb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frswcb.dto.AirlineDto;
import com.frswcb.entity.Airline;
import com.frswcb.service.AirlineService;
import com.frswcb.util.AirlineConverter;


@RestController
public class AirlineController {
	
	@Autowired
	AirlineConverter airlineConverter;
	
	@Autowired
	AirlineService airlineService;
	
	@PostMapping("/saveAirline")
	public AirlineDto saveAirline(@Valid @RequestBody AirlineDto airlineDto)
	{
		final Airline airline = airlineConverter.convertAirlineDtoToEntity(airlineDto);
		
		return airlineService.saveAirline(airline);
		
	}
	
	@PostMapping("/assignFlight/{fId}/toAirline/{aId}")
	public ResponseEntity<String> assignFlightToAirline(@PathVariable("aId")int aId,
			@PathVariable("fId") int fId)
	
	{
		airlineService.assignFlightToAirline(fId, aId);
		
		return new ResponseEntity<String>("Flight with id " +fId +"assigned to " +aId + " successfully" 
				, HttpStatus.OK);
		
	}
}
