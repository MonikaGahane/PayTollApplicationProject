package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
	List<Trip> findAllByTripDateBetweenOrderByTripDateDesc(LocalDateTime startDate, LocalDateTime endDate);

	List<Trip> findAllByVehicleNoAndTripDateBetweenOrderByTripDateDesc(String vehicleNumber, LocalDateTime startDate,
			LocalDateTime endDate);
	
	Double findSumFareAmountByTripDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
