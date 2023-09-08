package com.frswcb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frswcb.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	//custom method to find flight by source and destination
	
	@Query("from Flight where flightSource =:e")
	List <Flight>findFlightBySource(@Param("e") String flightSource);
	
	@Query("from Flight where flightDest =:d")
	List<Flight>findFlightByDest(@Param ("d")String flightDest);
	
	//custom method to fetch the flight details belonging to an Airline
	
	@Query("from Flight where airline = (from Airline where airlineName=:aName)")
	List<Flight> getFlightByAirline(@Param ("aName")String airlineName);
}
