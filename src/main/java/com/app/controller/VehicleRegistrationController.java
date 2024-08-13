package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.service.VehicleRegistrationService;

@RestController
@RequestMapping("/vehicle")
public class VehicleRegistrationController {
	
	
	@Autowired
	private VehicleRegistrationService vehicleRegistrationService;
	
	
	/*
	 * public UserDto addUser(UserDto userDto) { return
	 * vehicleRegistrationService.(userDto); }
	 */
	
	
	
	
	
}
