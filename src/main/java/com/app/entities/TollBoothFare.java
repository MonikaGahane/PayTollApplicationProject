package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="tollbooth_fares")
@Data
public class TollBoothFare {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long boothFareID;
	
	@Column(name="boothID")
	private Long boothID;
	
	@Enumerated(EnumType.STRING)
	@Column(name="vehicle_type", length = 40)
	private TypeVehicle vehicleType;
	
	@NotNull
	private double fare;
}
