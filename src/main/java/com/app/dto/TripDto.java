package com.app.dto;

import lombok.Data;

@Data
public class TripDto {
	
	private Long tripID;
	
	private Long boothID;
	
	private String vehicleNo;
	
	private double fareAmount;
	
	private String payMode;

}
