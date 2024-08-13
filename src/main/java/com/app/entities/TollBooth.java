package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="tollbooth")
@Data
public class TollBooth {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long booth_ID;
	
	@NotNull
	private String lane_No;
}
