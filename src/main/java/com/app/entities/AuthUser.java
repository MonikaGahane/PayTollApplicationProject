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
@Table(name="Auth_User")
@Data
public class AuthUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="authId")
	private Long authId;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@Column(name="admin")
	private Character admin;

}
