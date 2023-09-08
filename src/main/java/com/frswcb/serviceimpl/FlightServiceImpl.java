package com.frswcb.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Flight;
import com.frswcb.exceptions.ResourceNotFoundException;
import com.frswcb.repository.FlightRepository;
import com.frswcb.service.FlightService;
import com.frswcb.util.FlightConverter;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	FlightConverter flightConverter;
	

	@Override
	public FlightDto saveFlight(Flight flight) {
		
		
		flightRepository.save(flight);
		
		return flightConverter.convertEntityToFlightDto(flight);
	}

	@Override
	public FlightDto getFlightById(int fId) throws ResourceNotFoundException {
		
		Flight flight =flightRepository.findById(fId).orElseThrow(()->
		new ResourceNotFoundException("Flight" ,"fId", fId));
		
		return flightConverter.convertEntityToFlightDto(flight);
	}

	@Override
	public FlightDto updateFlight(int fId, Flight flight) throws ResourceNotFoundException {
		Flight existFlight = flightRepository.findById(fId).orElseThrow(()-> 
		new ResourceNotFoundException("Flight", "fId",fId));
		
		existFlight.setFlightNumber(flight.getFlightNumber());
		existFlight.setFlightSource(flight.getFlightSource());
		existFlight.setFlightDest(flight.getFlightDest());
		existFlight.setDuration(flight.getDuration());
		existFlight.setNoOfSeat(flight.getNoOfSeat());
		existFlight.setArrivalTime(flight.getArrivalTime());
		existFlight.setDepartureTime(flight.getDepartureTime());
		
		flightRepository.save(existFlight);
		
		return flightConverter.convertEntityToFlightDto(existFlight);
	}

	@Override
	public void deleteFlightById(int fId) {
		
		Flight flight =flightRepository.findById(fId).orElseThrow(()->
		new ResourceNotFoundException("Flight" ,"fId", fId));
		
		flightRepository.delete(flight);
		
	}

	@Override
	public List<FlightDto> getFlightBySource(String flightSource) {
		List <Flight> flights = flightRepository.findFlightBySource(flightSource);
		List<FlightDto> fDtos = new ArrayList<>();
		
		for(Flight f: flights)
		{
			fDtos.add(flightConverter.convertEntityToFlightDto(f));
		}
		return fDtos;
	}

	@Override
	public List<FlightDto> getAllFlights() {
		List<Flight> flights = flightRepository.findAll();
		List<FlightDto> fDtos = new ArrayList();
		
		for(Flight f: flights)
		{
			fDtos.add(flightConverter.convertEntityToFlightDto(f));
		}
		return fDtos;
	}

	@Override
	public List<FlightDto> getFlightByDest(String flightDest) {
		
		List <Flight> flights = flightRepository.findFlightByDest(flightDest);
		List<FlightDto> fDtos = new ArrayList<>();
		
		for(Flight f: flights)
		{
			fDtos.add(flightConverter.convertEntityToFlightDto(f));
		}
		return fDtos;
	}

	@Override
	public List<FlightDto> getFlightByAirline(String airlineName) {
		List<Flight>flights = flightRepository.getFlightByAirline(airlineName);
		
		List<FlightDto> fDtos = new ArrayList();
		
		for(Flight f: flights)
		{
			fDtos.add(flightConverter.convertEntityToFlightDto(f));
		}
		return fDtos;
	}
	
}