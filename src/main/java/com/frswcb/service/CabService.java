package com.frswcb.service;

import java.time.LocalDateTime;
import java.util.List;

import com.frswcb.dto.CabDto;

import com.frswcb.entity.Cab;


public interface CabService {

	//method to create and save flight details 
	CabDto saveCab( Cab cab);
	
	//method to assign cab to cab driver
	void assignCabDriverToCab(int cabId, int cdId);
	
	//method to fetch cab by arrival time
	List<CabDto> getCabByArrivalTime(LocalDateTime arrivalTime);
}
