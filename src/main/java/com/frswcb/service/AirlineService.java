package com.frswcb.service;

import com.frswcb.dto.AirlineDto;
import com.frswcb.entity.Airline;

public interface AirlineService {
	
	//method to save flight details 
	AirlineDto saveAirline(Airline airline);
		
	//method to assign flight to an airline
	void assignFlightToAirline(int fId , int airlineId);
}
