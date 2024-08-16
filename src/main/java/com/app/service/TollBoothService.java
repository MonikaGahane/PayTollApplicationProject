package com.app.service;

import com.app.dto.BoothFareDto;
import com.app.dto.TollBoothDto;

public interface TollBoothService {

	TollBoothDto addTollBooth(TollBoothDto tollBoothDto);

	BoothFareDto addBoothFares(BoothFareDto boothFareDto);
	
	Double getBoothFareForVehicleType(Long boothId, String vehicleType);
	
}
