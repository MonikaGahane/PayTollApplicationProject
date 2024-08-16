package com.app.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TripDto;
import com.app.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
	
	@PostMapping("/add")
	public ResponseEntity<TripDto> createTrip(@RequestBody TripDto tripDto) {
		return new ResponseEntity<TripDto>(tripService.createTrip(tripDto), HttpStatus.OK);
	}
	
	
	@GetMapping("/trips")
	public ResponseEntity<List<TripDto>> getTrips(@RequestParam(name = "fromDate") String fromDate, @RequestParam(name = "toDate") String toDate) {
		return new ResponseEntity<List<TripDto>>(Collections.EMPTY_LIST, HttpStatus.OK);
	}
	
	
	
	

}
