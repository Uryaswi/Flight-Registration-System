package com.frswcb.dto;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.frswcb.entity.Cab;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CabDriverDto extends UserDto{
	
	@NotNull(message = "contact is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}" , message = "Invalid contact details")
	private String contact;
	
	@ManyToOne // Many drivers can drive a particular cab accordingly
	private Cab cab;
}
