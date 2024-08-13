package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.WalletDto;
import com.app.entities.User;
import com.app.entities.Wallet;
import com.app.repository.WalletRepository;

@Service
public class WalletServeiceImpl implements WalletService {

//	@Autowired
//	private ObjectMapper objectMapper;

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public WalletDto createZeroBalanceWallet(Long user_Id) {
		User user = new User();
		user.setUserID(user_Id);
		Wallet wallet = new Wallet();
		wallet.setUserID(user);
		wallet.setBalance_amount(0);
		Wallet savedWallet = walletRepository.save(wallet);
		return convertToWalletDto(savedWallet);
	}

	@Override
	public WalletDto retriveWalletBalance(Long user_Id) {
		Wallet wallet = retriveWalletByUserId(user_Id);
		return convertToWalletDto(wallet);
	}

	private Wallet retriveWalletByUserId(Long user_Id) {
		User user = new User();
		user.setUserID(user_Id);
		Optional<Wallet> optionalWallet = walletRepository.findByUserID(user);
		if (optionalWallet.isEmpty()) {
			throw new ResourceNotFoundException("Wallet not found for user ID : " + user_Id);
		}
		return optionalWallet.get();
	}

	private WalletDto convertToWalletDto(Wallet wallet) {
		WalletDto walletDto = new WalletDto();
		walletDto.setWallet_ID(wallet.getWallet_ID());
		walletDto.setBalance_amount(wallet.getBalance_amount());
		return walletDto;
	}

	@Override
	@Transactional
	public WalletDto updateWalletBalance(Long user_Id, double amount) {
		Wallet wallet = retriveWalletByUserId(user_Id);
		wallet.setBalance_amount(wallet.getBalance_amount() + amount);
		Wallet savedWallet = walletRepository.save(wallet);
		return convertToWalletDto(savedWallet);
	}

}
