package com.frswcb.service;


import com.frswcb.dto.BookingDto;
import com.frswcb.entity.Booking;

public interface BookingService {
	
	Boolean bookFlight(int flightId , int noOfPass);
}
