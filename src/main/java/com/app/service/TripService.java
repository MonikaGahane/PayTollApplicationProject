package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.TripDto;

public interface TripService {
	
	 TripDto createTrip(TripDto tripDto);
	 
	 List<TripDto> getTrips(Optional<String> vehicleNumber, String fromDate,String toDate);

	 Double getCollectionAmountForDates(String fromDate, String toDate);
}
