package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.frswcb.dto.CabDto;

import com.frswcb.entity.Cab;


@Component
public class CabConverter {
	//method to convert DTO to entity
	
			public Cab convertCabDtoToEntity(CabDto cDto)
			{
				Cab cab = new Cab(); 
				
				if(cDto!=null)
				{
					BeanUtils.copyProperties(cDto, cab);
				}
				
				return cab;
			}
		//method to convert entity to DTO
			
			public CabDto convertEntityToCabDto(Cab cab)
			{
				CabDto cDto = new CabDto();
				if(cab!=null)
				{
					BeanUtils.copyProperties(cab, cDto);
				}
				return cDto;
				
			}
}
