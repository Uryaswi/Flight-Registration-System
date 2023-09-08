package com.frswcb.service;

import com.frswcb.dto.PassengerDto;
import com.frswcb.entity.Passenger;

public interface PassengerService {
	//method to create passenger details
	String createPassenger(Passenger pass);
	
	//method to save passenger 
	PassengerDto savePassenger( Passenger pass);
}
