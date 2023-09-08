package com.frswcb.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frswcb.dto.CabDto;
import com.frswcb.entity.Cab;
import com.frswcb.service.CabService;
import com.frswcb.util.CabConverter;


@RestController
public class CabController {
	
	@Autowired
	CabService cabService;
	
	@Autowired
	CabConverter cabConverter;
	
	@PostMapping("/saveCab")
	public CabDto saveStudent(@Valid @RequestBody  CabDto cabDto) {
		final	Cab cab = cabConverter.convertCabDtoToEntity(cabDto);
		return cabService.saveCab(cab);
	}
	
	@PostMapping("assignCabDriver/{cdId}/toCab/{cabId}")
	public ResponseEntity<String>assignCabToCabDriver(@PathVariable("cabId") int cabId , 
			@PathVariable("cdId") int cdId)
	{
		cabService.assignCabDriverToCab(cabId, cdId);
		return new ResponseEntity<String>("Cab with id"+ cabId +
		"assigned to " + cdId ,HttpStatus.OK);
		
	}
	
	@GetMapping("/getCabByArrivalTime/{arrivalTime}")
	public List<CabDto>getCabByArrivalTime(@PathVariable("arrivalTime")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime arrivalTime)
	{
		return cabService.getCabByArrivalTime(arrivalTime);
		
	}
}
