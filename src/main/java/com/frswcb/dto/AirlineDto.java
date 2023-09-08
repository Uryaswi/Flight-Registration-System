package com.frswcb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineDto {
	
	private int airlineId;
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 3 , message = "min 3 char required")
	@NotNull(message= "Airline  name  is required")
	@NotBlank(message = " Enter correct Airline name")
	private String airlineName;
}
