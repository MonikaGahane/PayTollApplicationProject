package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicleDto;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/add")
	public VehicleDto addVehicle(@RequestBody VehicleDto vehicleDto) {
		return vehicleService.addVehicle(vehicleDto);
	}

}
