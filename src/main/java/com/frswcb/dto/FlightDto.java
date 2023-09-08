package com.frswcb.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frswcb.entity.Airline;
import com.frswcb.entity.Booking;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FlightDto {

private int fId;
	
	@NotNull(message = "Flight number is required")
	@Size(min = 6 , message = "minimum 6 characters required")
	@Size(max = 6, message = " Number can be 6 characters long only")
	@NotBlank(message = "Please enter correct flight number")
	private String flightNumber;
	
	
	@NotNull(message = "Duration is required")
	private String duration;
	
	
	@NotNull(message = "No of seat  is required")
	private int noOfSeat;
	
	@NotNull(message = " departure time is required")
	private LocalDateTime departureTime;
	
	@NotNull(message = " arrival time is required")
	private LocalDateTime arrivalTime;
	
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 3 , message = "min 3 char required")
	@NotNull(message= "Source is required")
	private String flightSource;
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 3 , message = "min 3 char required")
	@NotNull(message= "Destination is required")
	private String flightDest;
	
	@ManyToOne
	private Airline airline;
	
	@OneToMany
	private List<Booking> bookings;
}

