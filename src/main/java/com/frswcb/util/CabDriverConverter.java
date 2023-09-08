package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.frswcb.dto.CabDriverDto;
import com.frswcb.entity.CabDriver;


@Component
public class CabDriverConverter {
	//method to convert DTO to entity
	public CabDriver convertCabDriverDtoToEntity(CabDriverDto cdDto)
	{
		CabDriver cabDriver = new CabDriver(); 
				
				if(cdDto!=null)
				{
					BeanUtils.copyProperties(cdDto, cabDriver);
				}
				
				return cabDriver;
			}
		//method to convert entity to DTO
			
			public CabDriverDto convertEntityToCabDriverDto(CabDriver cabDriver)
			{
				CabDriverDto cdDto = new CabDriverDto();
				if(cabDriver!=null)
				{
					BeanUtils.copyProperties(cabDriver, cdDto);
				}
				return cdDto;
				
			}
}
