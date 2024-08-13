package com.app.entities;

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
@Table(name="vehicles")
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long vehicle_No;
	
	@ManyToOne
	@JoinColumn(name = "user_ID")
	private User user_ID;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_type")
	private VehicleType vehicle_type;
}
