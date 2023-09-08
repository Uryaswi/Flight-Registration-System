package com.frswcb.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frswcb.dto.CabDto;
import com.frswcb.entity.Cab;
import com.frswcb.entity.CabDriver;
import com.frswcb.repository.AddressRepository;
import com.frswcb.repository.CabDriverRepository;
import com.frswcb.repository.CabRepository;
import com.frswcb.repository.RoleRepository;
import com.frswcb.service.CabService;
import com.frswcb.util.CabConverter;
import com.frswcb.entity.Role;
import com.frswcb.exceptions.ResourceNotFoundException;

@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	CabRepository cabRepository;
	
	@Autowired
	CabConverter cabConverter;
	
	@Autowired
	AddressRepository addRepository;
	
	@Autowired
	CabDriverRepository cdRepository;
	
	@Override
	public CabDto saveCab(Cab cab) {
		
		addRepository.save(cab.getAddress());
		
		cabRepository.save(cab);
		
		return cabConverter.convertEntityToCabDto(cab);
	}

	@Override
	public void assignCabDriverToCab(int cabId, int cdId) {
		Cab cab = cabRepository.findById(cdId).orElseThrow(()->
		new ResourceNotFoundException("Cab", "cabId", cabId));
		
		CabDriver cabDriver = cdRepository.findById(cabId).orElseThrow(()->
		new ResourceNotFoundException("CabDriver", "userId", cdId));
		
		cabDriver.setCab(cab);
		cab.setTotalDriversAlloted(cab.getTotalDriversAlloted()+1);
		
		cabRepository.save(cab);
		cdRepository.save(cabDriver);
		
	}

	@Override
	public List<CabDto> getCabByArrivalTime(LocalDateTime arrivalTime) {
		List <Cab> cabs = cabRepository.findCabByArrivalTime(arrivalTime);
		List<CabDto> cabDtos = new ArrayList<>();
		
		for(Cab c: cabs)
		{
			cabDtos.add(cabConverter.convertEntityToCabDto(c));
		}
		return cabDtos;
	}
	
}
