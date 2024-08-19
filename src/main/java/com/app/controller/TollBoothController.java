package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BoothFareDto;
import com.app.dto.TollBoothDto;
import com.app.service.TollBoothService;
import com.app.service.TripService;

@RestController
@RequestMapping("/tollbooth")
@CrossOrigin(origins = "*")
public class TollBoothController {
	
	@Autowired
	private TollBoothService tollBoothService;
	
	@Autowired
	private TripService tripService;
	
	@PostMapping("/add")
	public TollBoothDto addTollBooth(@RequestBody TollBoothDto tollBoothDto) {
		return tollBoothService.addTollBooth(tollBoothDto);
	}
	
	@PostMapping("/addFares")
	public BoothFareDto addBoothFares(@RequestBody BoothFareDto boothFareDto) {
		return tollBoothService.addBoothFares(boothFareDto);
	}
	
	@GetMapping("/collection") 
	public Double getCollection(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate ) {
			return tripService.getCollectionAmountForDates(fromDate, toDate);
	}
}
