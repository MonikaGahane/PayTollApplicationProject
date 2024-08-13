package com.app.service;

import com.app.dto.UserDto;

public interface UserRegistrationService {
	
	UserDto addUser(UserDto user);
	
	UserDto retriveUser(Long user_ID);
	
//	WalletDto updateWalletBalance(Long user_Id, double amount);
	
}
