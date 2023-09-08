package com.frswcb.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.frswcb.entity.Flight;
import com.frswcb.repository.FlightRepository;
import com.frswcb.service.FlightService;

@SpringBootTest
class FlightServiceTest {
	
	@Autowired
	FlightService flightService;
	
	@MockBean
	FlightRepository flightRepository;
	
	@Test
	void testsaveFlight() {
		Flight flight = Flight.builder().flightNumber("B2WR10").duration("2 hr").noOfSeat(100).
				departureTime(LocalDateTime.of(2023, 9, 7, 15, 30, 0)).
		arrivalTime(LocalDateTime.of(2023, 9, 7, 17, 30, 0)).flightSource("Kolkata,India").
		flightDest("Delhi,India").build();
		
		Mockito.when(flightRepository.save(flight)).thenReturn(flight);
		
		assertEquals("B2WR10" , flightService.saveFlight(flight).getFlightNumber());
	}
	
	
	@Test
	@DisplayName("Negetive Test Case")
	void testgetFlightById()
	{
		Flight flight = Flight.builder().flightNumber("B2WR10").duration("2 hr").noOfSeat(100).
				departureTime(LocalDateTime.of(2023, 9, 7, 15, 30, 0)).
		arrivalTime(LocalDateTime.of(2023, 9, 7, 17, 30, 0)).flightSource("Kolkata,India").
		flightDest("Delhi,India").build();
		
		Optional<Flight> opFlight = Optional.of(flight);
		Mockito.when(flightRepository.findById(flight.getFId())).thenReturn(opFlight);
		
		String duration = flightService.getFlightById(flight.getFId()).getDuration();
		assertTrue(duration.equals("1 hr"));
	}

}
