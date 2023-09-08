package com.frswcb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Flight;
import com.frswcb.service.FlightService;

import com.frswcb.util.FlightConverter;


@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	
	@Autowired
	FlightConverter flightConverter;
	
	
	@PostMapping("/saveFlight")
	public FlightDto savePassenger(@Valid @RequestBody FlightDto flightDto)
	{
		final Flight flight = flightConverter.convertFlightDtoToEntity(flightDto);
		return flightService.saveFlight(flight);
		
	}
	
	@GetMapping("/getFlightById/{fId}")
	public FlightDto getFlightById(@PathVariable("fId") int fId)
	{
		return flightService.getFlightById(fId);
	}
	
	@PutMapping("/updateFlight/{fId}")
	public FlightDto updateFlight(@PathVariable("fId")int fId, @Valid @RequestBody FlightDto flightDto)
	{
		final Flight flight = flightConverter.convertFlightDtoToEntity(flightDto);
		return flightService.updateFlight(fId, flight);
	}
	
	@DeleteMapping("/deleteByFlightId/{fId}")
	public ResponseEntity<String> deleteFlightById(@PathVariable("fId") int fId)
	{
		flightService.deleteFlightById(fId);
		return new ResponseEntity<String>("Flight with id:" +fId+ "deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getFlightBySource/{source}")
	public List<FlightDto> findFlightBySource (@PathVariable("source") String flightSource)
	{
		return flightService.getFlightBySource(flightSource);
	}
	
	@GetMapping("/getAllFlights")
	public List<FlightDto> getAllFlights()
	{
		return flightService.getAllFlights();
	}
	
	@GetMapping("/getFlightByFlightDest/{flightDest}")
	public List<FlightDto> findFlightByDest(@PathVariable("flightDest")String flightDest)
	{
		return flightService.getFlightByDest(flightDest);
	}
	
	@GetMapping("/fetchFlightByAirline/{aName}")
	public List<FlightDto> findFlightByAirline(@PathVariable ("aName")String airlineName)
	{
		return flightService.getFlightByAirline(airlineName);
	}
}
