package com.frswcb.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frswcb.entity.Address;
import com.frswcb.entity.CabDriver;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CabDto {
private int cabId;
	
	@NotNull(message = "Cab number is required")
	@Size(min = 6 , message = "minimum 6 characters required")
	@Size(max = 6, message = " Number can be 6 characters long only")
	@NotBlank(message = "Please enter correct cab number")
	private String cabNumber;
	
	@NotNull(message = "departure time is required")
	private LocalDateTime destinationTime;
	
	@NotNull(message = " arrival time is required")
	private LocalDateTime arrivalTime;
	
	@NotNull(message = " no of seat is required")
	private int noOfSeat;
	
	@NotNull(message = "no of drivers alloted to the cab can not be empty")
	private int totalDriversAlloted;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<CabDriver> cabDrivers;// one cab can be driven by many drivers
	
}
