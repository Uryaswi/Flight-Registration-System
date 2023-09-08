package com.frswcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	@Column(length = 100 , nullable = false)
	private String fromLocality;
	
	@Column(length = 100 , nullable = false)
	private String toLocality;
	
	@Column(length = 50 , nullable = false)
	private String state;
	
	@Column(length = 50 , nullable = false)
	private String city;
	
	@Column(nullable = false)
	private int sourcePincode;
	
	@Column(nullable = false)
	private int destPincode;
	
}
