package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TollBooth;
import com.app.entities.TollBoothFare;

public interface TollBoothRepository extends JpaRepository<TollBooth, Long> {

	

}
