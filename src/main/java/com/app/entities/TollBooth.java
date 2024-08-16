package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="tollbooths")
@Data
public class TollBooth {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="boothID")
	private Long boothID;
	
	@NotNull
	private String boothName;
}
