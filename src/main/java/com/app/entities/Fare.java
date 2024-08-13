package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="fares")
@Data
public class Fare {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long fare_ID;
	
	@ManyToOne
    @JoinColumn(name = "vehicle_type")
	private VehicleType vehicle_type;
	
	@ManyToOne
    @JoinColumn(name = "vehicle_No")
	private Vehicle vehicle_No;
	
	@ManyToOne
    @JoinColumn(name = "booth_ID")
	private TollBooth booth_ID;
	
	@NotNull
	private double totalFareAmount;
	
	@NotNull
	private LocalDateTime paid_date;
	
	
	
}
