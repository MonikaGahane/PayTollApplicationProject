package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TollBoothFare;

public interface TollBoothFareRepository extends JpaRepository<TollBoothFare, Long> {

}
