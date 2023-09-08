package com.frswcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CabBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabBookingId;
	
	@Column( nullable = false)
	private String status;
	
	
	
	@OneToOne // One passenger can book one cab
	private Cab cab;
}
