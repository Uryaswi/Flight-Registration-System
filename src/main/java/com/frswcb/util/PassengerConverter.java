package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import com.frswcb.dto.PassengerDto;

import com.frswcb.entity.Passenger;

@Component
public class PassengerConverter {
	//method to convert DTO to entity
	
			public Passenger convertPassengerDtoToEntity(PassengerDto pDto)
			{
				Passenger passenger = new Passenger(); 
				
				if(pDto!=null)
				{
					BeanUtils.copyProperties(pDto, passenger);
				}
				
				return passenger;
			}
		//method to convert entity to DTO
			
			public PassengerDto convertEntityToPassengerDto(Passenger passenger)
			{
				PassengerDto pDto = new PassengerDto();
				if(passenger!=null)
				{
					BeanUtils.copyProperties(passenger, pDto);
				}
				return pDto;
				
			}
}
