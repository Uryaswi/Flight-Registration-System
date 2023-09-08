package com.frswcb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.AirlineDto;
import com.frswcb.entity.Airline;
import com.frswcb.entity.Flight;
import com.frswcb.exceptions.ResourceNotFoundException;
import com.frswcb.repository.AirlineRepository;
import com.frswcb.repository.FlightRepository;
import com.frswcb.service.AirlineService;
import com.frswcb.util.AirlineConverter;

@Service
	
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	AirlineRepository airlineRepository;
	
	@Autowired
	AirlineConverter airlineConverter;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public AirlineDto saveAirline(Airline airline) {
		
		airlineRepository.save(airline);
		
		return airlineConverter.convertEntityToAirlineDto(airline);
	}

	@Override
	public void assignFlightToAirline(int fId, int airlineId) 
	{
		Flight flight = flightRepository.findById(fId).orElseThrow(()->
		new ResourceNotFoundException("Flight" , "fId" , fId));
		
		Airline airline = airlineRepository.findById(airlineId).orElseThrow(()-> 
		new ResourceNotFoundException ("Airline" , "airlineId" , airlineId));
		
		flight.setAirline(airline);
		
		List<Flight> list = airline.getFlights();
		list.add(flight);
		airline.setFlights(list);
		
		flightRepository.save(flight);
		airlineRepository.save(airline);
		
	}

}
