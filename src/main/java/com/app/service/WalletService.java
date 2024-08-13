package com.app.service;

import com.app.dto.WalletDto;

public interface WalletService {

	WalletDto createZeroBalanceWallet(Long user_Id);

	WalletDto retriveWalletBalance(Long user_Id);

	WalletDto updateWalletBalance(Long user_Id, double amount);

}
