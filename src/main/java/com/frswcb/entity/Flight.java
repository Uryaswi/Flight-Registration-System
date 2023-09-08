package com.frswcb.entity;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Flight{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;
	
	@Column(length = 50 , nullable = false, unique = true)
	private String flightNumber;
	
	@Column(nullable = false)
	private String duration;
	
	@Column(nullable = false)
	private int noOfSeat;//
	
	@Column(nullable = false)
	private LocalDateTime departureTime;
	
	@Column(nullable = false)
	private LocalDateTime arrivalTime;
	
	
	@Column(nullable = false)
	private String flightSource;
	
	@Column(nullable = false)
	private String flightDest;
	
	@ManyToOne
	private Airline airline;
	
	@OneToMany
	private List<Booking> bookings;
}
