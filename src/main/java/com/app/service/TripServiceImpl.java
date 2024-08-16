package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.BadRequestException;
import com.app.dto.TripDto;
import com.app.dto.WalletDto;
import com.app.entities.PayMode;
import com.app.entities.TollBooth;
import com.app.entities.Trip;
import com.app.entities.Vehicle;
import com.app.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired 
	private TollBoothService tollBoothService;
	

	@Override
	public TripDto createTrip(TripDto tripDto) {
		Trip trip = createTripEntity(tripDto);
		return convertToDto(trip);
	}

	@Override
	public List<TripDto> getTrips(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	private Trip createTripEntity(TripDto tripDto) {
		Trip  trip = new Trip();
		trip.setVehicleNo(tripDto.getVehicleNo());
		trip.setTripDate(LocalDateTime.now());
		trip.setPayMode(PayMode.valueOf(tripDto.getPayMode()));
		
		Vehicle vehicle = getVehicle(tripDto.getVehicleNo());
		WalletDto walletDto = getWallet(vehicle.getUserID().getUserID());
		
		TollBooth tollBooth = new TollBooth();
		tollBooth.setBoothID(tripDto.getBoothID());
		trip.setBoothID(tollBooth);
		
		double boothCharge = getBoothCharge(tripDto.getBoothID(), vehicle.getVehicleType().name());
		
		if((walletDto.getBalanceAmount() - boothCharge) < 0) {
			throw new BadRequestException("Insufficient Wallet Balance for your vehicle :" + tripDto.getVehicleNo());
		}
		
		walletDto.setBalanceAmount(walletDto.getBalanceAmount() - boothCharge);
		walletService.updateWalletBalance(walletDto.getWalletID(), walletDto.getBalanceAmount());
		
		trip.setFareAmount(boothCharge);
		
		Trip persistedTrip = tripRepository.save(trip);
		
		return persistedTrip;
	}
	
	private Vehicle getVehicle(String vehicleNumber) {
		Optional<Vehicle> vehicleOpt = vehicleService.getVehicle(vehicleNumber);
		if(vehicleOpt.isEmpty()) {
			throw new BadRequestException(vehicleNumber + " is Invalid");
		}
		return vehicleOpt.get();
	}
	
	private WalletDto getWallet(Long userId) {
		WalletDto walletDto = walletService.retrieveWalletBalance(userId);
		return walletDto;
	}
	
	private double getBoothCharge(Long boothId, String vehicleType) {
		return tollBoothService.getBoothFareForVehicleType(boothId, vehicleType);
	}
	
	private TripDto convertToDto(Trip trip) {
		TripDto tripDto = new TripDto();
		tripDto.setBoothID(trip.getBoothID().getBoothID());
		tripDto.setFareAmount(trip.getFareAmount());
		tripDto.setPayMode(trip.getPayMode().name());
		tripDto.setTripID(trip.getTripID());
		tripDto.setVehicleNo(trip.getVehicleNo());
		return tripDto;
	}
	
}
