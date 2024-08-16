package com.app.service;

import com.app.dto.UserDto;

public interface UserService {
	
	UserDto addUser(UserDto userDto);
	
	UserDto retrieveUser(Long user_ID);
	
//	WalletDto updateWalletBalance(Long user_Id, double amount);
	
}
