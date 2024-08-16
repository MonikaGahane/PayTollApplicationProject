package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
