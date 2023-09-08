package com.frswcb.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frswcb.entity.Cab;

public interface CabRepository extends JpaRepository<Cab, Integer> {

	//custom method to find cab by arrival time 
	@Query("from Cab where arrivalTime =:a")
	List<Cab> findCabByArrivalTime (@Param("a")LocalDateTime arrivalTime);
	
}
