package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.BoothFareDto;
import com.app.dto.Fare;
import com.app.dto.TollBoothDto;
import com.app.entities.TollBooth;
import com.app.entities.TollBoothFare;
import com.app.entities.TypeVehicle;
import com.app.repository.TollBoothFareRepository;
import com.app.repository.TollBoothRepository;

@Service
public class TollBoothServiceImpl implements TollBoothService {
	
	@Autowired
	private TollBoothRepository tollBoothRepository;
	
	@Autowired
	private TollBoothFareRepository tollBoothFareRepository;
	
	@Override
	public TollBoothDto addTollBooth(TollBoothDto tollBoothDto) {
		TollBooth tollBooth = new TollBooth();
		tollBooth.setBoothName(tollBoothDto.getBoothName());
		TollBooth savedTollBooth = tollBoothRepository.save(tollBooth);
		tollBoothDto.setBoothID(savedTollBooth.getBoothID());
		return tollBoothDto;
	}

	@Override
	public BoothFareDto addBoothFares(BoothFareDto boothFareDto) {
		List<TollBoothFare> entitiesList = new ArrayList<>();
		for(Fare fare : boothFareDto.getFares()) {
			TollBoothFare tollBoothFare = new TollBoothFare();
			tollBoothFare.setBoothID(boothFareDto.getBoothID());
			tollBoothFare.setFare(fare.getFare());
			tollBoothFare.setVehicleType(TypeVehicle.valueOf(fare.getVehicleType()));
			entitiesList.add(tollBoothFareRepository.save(tollBoothFare));
		}
		return convertToDto(boothFareDto.getBoothID(), entitiesList);
	}
	
	private BoothFareDto convertToDto(Long boothId, List<TollBoothFare> entitiesList) {
		BoothFareDto returnDto = new BoothFareDto();
		returnDto.setBoothID(boothId);
		List<Fare> faresDtoList = new ArrayList<>();
		entitiesList.forEach(entity -> {
			Fare fare = new Fare();
			fare.setBoothFareID(entity.getBoothFareID());
			fare.setFare(entity.getFare());
			fare.setVehicleType(entity.getVehicleType().name());
			faresDtoList.add(fare);
		});
		returnDto.setFares(faresDtoList);
		return returnDto;
		
	}

	@Override
	public Double getBoothFareForVehicleType(Long boothId, String vehicleType) {
		List<TollBoothFare> tollBoothFares = tollBoothFareRepository.findByBoothID(boothId);
		Optional<TollBoothFare> boothFare = tollBoothFares.stream().filter(booth -> booth.getVehicleType()== TypeVehicle.valueOf(vehicleType)).findFirst();
		return boothFare.get().getFare();
	}
	


}

