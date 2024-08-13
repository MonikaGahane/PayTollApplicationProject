package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.WalletDto;
import com.app.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	@Autowired
	private WalletService walletService;
	
	@GetMapping("/retriveBalance/{user_Id}")
	public WalletDto retriveWalletBalance(@PathVariable Long user_Id) {
		return walletService.retriveWalletBalance(user_Id);
	}
	
	// API to update the wallet balance
	@PutMapping("/update/{user_Id}")
	public WalletDto updateWalletBalance(@PathVariable Long user_Id, @RequestParam(name = "balance_amount") double amount) {
		return walletService.updateWalletBalance(user_Id, amount);
	}
}
