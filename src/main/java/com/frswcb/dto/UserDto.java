package com.frswcb.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frswcb.entity.Role;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
private int userId;
	
	@NotNull(message = "name is required")
	@Size(min = 2 , message = "minimum 2 characters required")
	@Size(max = 30 , message = " Name can be 30 letters long only")
	
	private String userName;
	
	@NotNull(message = "password is required")
	@Size(min = 6 , message = "minimum 6 characters required")
	@Size(max = 12 , message = " Name can be 30 letters long only")
	private String userPassword;
	

	@Size(max = 50 , message = "Maximum 30 characters allowed")
	@Email(message = " invalid email")
	private String email;

	
	@OneToOne
	private Role role;

}
