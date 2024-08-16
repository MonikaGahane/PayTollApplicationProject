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
@Table(name="vehicles")
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vehicleID")
	private Long vehicleID;
	
	@NotNull
	@Column(name="vehicleNo")
	private String vehicleNumber;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User userID;

	@Enumerated(EnumType.STRING)
	@Column(name="vehicle_type", length = 40)
	private TypeVehicle vehicleType;
}
