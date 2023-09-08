package com.frswcb.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressDto {
private int addId;
	
	@Size(max = 100 , message = "max limit 100 characters")
	@NotNull(message= "locality is required")
	private String fromLocality;
	
	@Size(max = 100 , message = "max limit 100 characters")
	@NotNull(message= "locality is required")
	private String toLocality;
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 3 , message = "min 3 char required")
	@NotNull(message= "state is required")
	private String state;
	
	@Size(max = 50 , message = "max limit 50 characters")
	@Size(min = 2 , message = "min 2 char required")
	@NotNull(message= "city is required")
	private String city;
	
	@Size(max = 6 , message = "max limit 6 characters")
	@Size(min = 6 , message = "min 6 char required")
	@NotNull(message= "pin code is required")
	private int fromPincode;
	
	@Size(max = 6 , message = "max limit 6 characters")
	@Size(min = 6 , message = "min 6 char required")
	@NotNull(message= "pin code is required")
	private int ToPincode;
	
}
