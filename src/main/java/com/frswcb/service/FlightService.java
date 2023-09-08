package com.frswcb.service;

import java.util.List;

import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Flight;


public interface FlightService {
	
		
	//method to create and save flight details 
	FlightDto saveFlight( Flight flight);
	
	//method to get all flights
	List<FlightDto>getAllFlights();
	
	//method to get flight by id
	FlightDto getFlightById(int fId);
	
	//method to update flight details
	FlightDto updateFlight(int fId, Flight flight);
	
	//method to delete by id
	void deleteFlightById(int fId);
	
	//method to fetch flight details using source
	List <FlightDto> getFlightBySource(String flightSource );
	
	//method to get flight by destination
	List <FlightDto> getFlightByDest(String flightDest);
	
	//method to get flight by airline name
	List<FlightDto> getFlightByAirline(String airlineName);
	
}
