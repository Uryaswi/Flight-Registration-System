package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.frswcb.dto.AirlineDto;
import com.frswcb.entity.Airline;

@Component
public class AirlineConverter {
	//method to convert DTO to entity
	
			public Airline convertAirlineDtoToEntity(AirlineDto aDto)
			{
				Airline airline = new Airline(); 
				
				if(aDto!=null)
				{
					BeanUtils.copyProperties(aDto, airline);
				}
				
				return airline;
			}
		//method to convert entity to DTO
			
			public AirlineDto convertEntityToAirlineDto(Airline airline)
			{
				AirlineDto aDto = new AirlineDto();
				if(airline!=null)
				{
					BeanUtils.copyProperties(airline, aDto);
				}
				return aDto;
				
			}
}
