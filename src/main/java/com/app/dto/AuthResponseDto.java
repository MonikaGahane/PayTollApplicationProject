package com.app.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
	
	private String userName;
	
	private Character admin;
	
	private String email;
	
	private Long userId;

}
