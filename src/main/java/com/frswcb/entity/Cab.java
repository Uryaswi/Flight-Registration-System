package com.frswcb.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;
	
	@Column(length = 50, unique = true, nullable = false)
	private String cabNumber;
	
	@Column(nullable = false)
	private LocalDateTime destinationTime;
	
	@Column(nullable = false)
	private LocalDateTime arrivalTime;
	
	@Column(nullable = false)
	private int noOfSeat;
	
	@Column(nullable = false)
	private int totalDriversAlloted;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<CabDriver> cabDrivers;// one cab can be driven by many drivers
	
}
