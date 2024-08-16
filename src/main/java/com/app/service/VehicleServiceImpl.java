package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.BadRequestException;
import com.app.dto.VehicleDto;
import com.app.entities.TypeVehicle;
import com.app.entities.User;
import com.app.entities.Vehicle;
import com.app.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public VehicleDto addVehicle(VehicleDto vehicleDto) {	
		validateVehicle(vehicleDto.getVehicleNumber()); 
		Vehicle vehicle = convertToVehicleEntity(vehicleDto);
		Vehicle savedVehicle = vehicleRepository.save(vehicle);
		return convertToVehicleDto(savedVehicle, vehicleDto.getVehicleType());
	}
	
	private void validateVehicle(String vehicleNumber) {
		Optional<Vehicle> optVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
		if(optVehicle.isPresent()) {
			throw new BadRequestException(vehicleNumber + " is already registered");
		}
	}
	
	private Vehicle convertToVehicleEntity(VehicleDto vehicleDto) {
		User user = new User();
		user.setUserID(vehicleDto.getUserID());
		
		Vehicle vehicle = new Vehicle();
		vehicle.setUserID(user);
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		
		/*
		 * VehicleType vehicleType = new VehicleType();
		 * vehicleType.setVehicleType(TypeVehicle.valueOf(vehicleDto.getVehicleType().
		 * toUpperCase()));
		 */
		
		vehicle.setVehicleType(TypeVehicle.valueOf(vehicleDto.getVehicleType().toUpperCase()));
		
		return vehicle;
	}
	
	private VehicleDto convertToVehicleDto(Vehicle vehicle, String vehicleType) {
		return new VehicleDto(vehicle.getVehicleID(), vehicle.getVehicleNumber(), vehicle.getUserID().getUserID(),  vehicleType);
	}
	
}
