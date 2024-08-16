package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	Optional<Vehicle> findByVehicleNumber(String vehicleNumber);

}
