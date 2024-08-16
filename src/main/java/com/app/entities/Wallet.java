package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Table(name="wallet")
@Data
public class Wallet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="walletID")
	private Long walletID;
	
	@NotNull
	private double balanceAmount;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	private User userID;

	

}
