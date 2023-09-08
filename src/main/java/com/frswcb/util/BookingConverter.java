package com.frswcb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.frswcb.dto.BookingDto;
import com.frswcb.dto.FlightDto;
import com.frswcb.entity.Booking;
import com.frswcb.entity.Flight;

@Component
public class BookingConverter {
	public Booking convertBookingDtoToEntity(BookingDto bDto)
	{
		Booking booking = new Booking(); 
		
		if(bDto!=null)
		{
			BeanUtils.copyProperties(bDto, booking);
		}
		
		return booking;
	}
//method to convert entity to DTO
	
	public BookingDto convertEntityToBookingDto(Booking booking)
	{
		BookingDto bDto = new BookingDto();
		if(booking!=null)
		{
			BeanUtils.copyProperties(booking, bDto);
		}
		return bDto;
		
	}
}
