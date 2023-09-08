package com.frswcb.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PassengerDto extends UserDto {
	
	@NotNull(message = "contact is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}" , message = "Invalid contact details")
	private String contact;
	
}
