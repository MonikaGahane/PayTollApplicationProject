package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="vehicle_types")
@Data
public class VehicleType {
	@Id
	@Enumerated(EnumType.STRING)
	private TypeVehicle vehicle_type;
}
