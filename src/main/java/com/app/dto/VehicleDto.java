package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

	private Long vehicleID;

	private String vehicleNumber;

	private Long userID;

	private String vehicleType;
}
