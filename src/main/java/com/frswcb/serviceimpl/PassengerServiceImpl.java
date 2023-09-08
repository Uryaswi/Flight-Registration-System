package com.frswcb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.PassengerDto;
import com.frswcb.entity.Passenger;
import com.frswcb.entity.Role;
import com.frswcb.repository.PassengerRepository;
import com.frswcb.repository.RoleRepository;
import com.frswcb.service.PassengerService;
import com.frswcb.util.PassengerConverter;

@Service
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	PassengerRepository passRepository;
	
	@Autowired
	PassengerConverter passConverter;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public String createPassenger(Passenger pass)
	{
		passRepository.save(pass);
		
		return "Passenger details saved successfully";
		
	}
	@Override
	public PassengerDto savePassenger(Passenger pass)
	{
		Role role = roleRepository.findById(2).get();
		
		pass.setRole(role);
		
		passRepository.save(pass);
		
		return passConverter.convertEntityToPassengerDto(pass);
		
	}
}
