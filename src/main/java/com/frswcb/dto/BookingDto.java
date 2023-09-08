package com.frswcb.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frswcb.entity.Flight;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class BookingDto {
	
	private int bookingId;
	
	@NotNull(message = "Confirmation Id must not be null")
	private double confirmationId;
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 12 , message = "min 3 char required")
	@NotNull(message= "Status is required")
	private String status;
	
	@NotNull(message= "noOfPass is required")
	private int noOfPass;
	
	
	@ManyToOne //one flight can take many booking
	private Flight flight;
	
	
}
