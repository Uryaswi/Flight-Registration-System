package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Flight;



@Component
public class FlightConverter {
	//method to convert DTO to entity
	
		public Flight convertFlightDtoToEntity(FlightDto fDto)
		{
			Flight flight = new Flight(); 
			
			if(fDto!=null)
			{
				BeanUtils.copyProperties(fDto, flight);
			}
			
			return flight;
		}
	//method to convert entity to DTO
		
		public FlightDto convertEntityToFlightDto(Flight flight)
		{
			FlightDto fDto = new FlightDto();
			if(flight!=null)
			{
				BeanUtils.copyProperties(flight, fDto);
			}
			return fDto;
			
		}
}
