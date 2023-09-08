package com.frswcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Checkin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int checkinId;
	
	@Column(nullable = false, unique = true)
	private String gateNo;
	
	@Column(nullable = false, unique = true)
	private String seatNo;
	
	@OneToOne
	private Passenger passCheck;
}
