package com.frswcb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


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
public class CabDriver extends User {
	
	@Column(nullable = false, unique = true, length = 10)
	private String contact;
	
	@Builder
	public CabDriver(int userId, String userName, String userPassword, String email, Role role, String contact,
			Cab cab) {
		super(userId, userName, userPassword, email, role);
		this.contact = contact;
		this.cab = cab;
	}

	@ManyToOne // Many drivers can drive a particular cab accordingly
	private Cab cab;
}
