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
@Table(name="trips")
@Data
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long trip_ID;
	
	@NotNull
	private LocalDateTime trip_date;
	
	@ManyToOne
    @JoinColumn(name = "booth_ID")
	private TollBooth booth_ID;
	
	@ManyToOne
    @JoinColumn(name = "vehicle_No")
	private Vehicle vehicle_No;
	
	@ManyToOne
    @JoinColumn(name = "fare_ID")
	private Fare fare_ID;
}
