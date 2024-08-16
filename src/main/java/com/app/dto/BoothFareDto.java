package com.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoothFareDto {

	private Long boothID;

	private List<Fare> fares;

}
