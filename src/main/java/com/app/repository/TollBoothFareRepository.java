package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TollBoothFare;

public interface TollBoothFareRepository extends JpaRepository<TollBoothFare, Long> {
	
	List<TollBoothFare> findByBoothID(Long boothID);

}
