package com.frswcb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airlineId;
	
	@Column(length = 50 , nullable = false, unique = true)
	private String airlineName;
	
	@OneToMany
	private List<Flight>flights;
}
