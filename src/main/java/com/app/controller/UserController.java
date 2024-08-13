package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@PostMapping("/add")
	public UserDto addUser(@RequestBody UserDto userDto) {
//		userRegistrationService.addUser(userDto);
//		walletService.createZeroBalanceWallet(userDto.getUser_ID());
//		return userDto;
		return userRegistrationService.addUser(userDto);
	}
	
	@GetMapping("/retrive/{user_id}")
	public UserDto retrive(@PathVariable Long user_id) {
		return userRegistrationService.retriveUser(user_id);
	}
	
	
//	@PostMapping("/wallet/update")
//	public WalletDto updateWalletBalance(@RequestBody Long user_Id, double amount) {
//		return userRegistrationService.updateWalletBalance(user_Id, amount);
//	}
}
