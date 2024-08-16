package com.app.entities;

import java.time.LocalDateTime;

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
@Table(name="trips")
@Data
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tripID")
	private Long tripID;
	
	@NotNull
	private LocalDateTime tripDate;
	
	@ManyToOne
    @JoinColumn(name = "boothID")
	private TollBooth boothID;
	
	@NotNull
	private String vehicleNo;
	
	@NotNull
	private double fareAmount;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PayMode payMode;
	
	

}
