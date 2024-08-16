package com.app.service;

import java.util.List;

import com.app.dto.TripDto;

public interface TripService {
	
	 TripDto createTrip(TripDto tripDto);
	 
	 List<TripDto> getTrips(String fromDate,String toDate);

}
