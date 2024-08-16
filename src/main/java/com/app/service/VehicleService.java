package com.app.service;

import java.util.Optional;

import com.app.dto.VehicleDto;
import com.app.entities.Vehicle;

public interface VehicleService {
	
	VehicleDto addVehicle(VehicleDto vehicleDto);
	
	Optional<Vehicle> getVehicle(String vehicleNumber);
}
