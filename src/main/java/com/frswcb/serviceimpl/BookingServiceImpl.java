package com.frswcb.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.BookingDto;
import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Booking;
import com.frswcb.entity.Flight;
import com.frswcb.exceptions.ResourceNotFoundException;
import com.frswcb.repository.BookingRepository;
import com.frswcb.repository.FlightRepository;
import com.frswcb.service.BookingService;

import com.frswcb.util.BookingConverter;
@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingConverter bConverter;
	@Autowired
	BookingRepository bRepository;
	
	@Autowired
	FlightRepository flightRepository;
	@Override
	public Boolean bookFlight(int flightId, int noOfPass) {
		Optional <Flight> opFlight = flightRepository.findById(flightId);
		
		if(opFlight!= null)
		{
			Flight flight = opFlight.get();
			
			if(flight.getNoOfSeat()>= noOfPass)
			{
				flight.setNoOfSeat(flight.getNoOfSeat()-noOfPass);
				flightRepository.save(flight);
				return true;
			}
		}
		return false;
	}
	
}
