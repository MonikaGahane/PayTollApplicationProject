package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.UserDto;
import com.app.entities.User;
import com.app.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired 
	private WalletService walletService;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = objectMapper.convertValue(userDto, User.class);
		User savedUser = userRepository.save(user);
		walletService.createZeroBalanceWallet(savedUser.getUserID());
		return objectMapper.convertValue(savedUser, UserDto.class);
	}

	@Override
	public UserDto retriveUser(Long user_ID) {
		Optional<User> optUser = userRepository.findById(user_ID);
		if (optUser.isEmpty()) { 
			throw new ResourceNotFoundException("User not available for UserId:"+ user_ID);
		}
		User user = optUser.get();
		UserDto userDto = objectMapper.convertValue(user, UserDto.class);
		return userDto;
	}

//	@Override
//	public WalletDto updateWalletBalance(Long user_Id, double amount) {
//		WalletService walletService = new WalletServeiceImpl();
//		WalletDto walletDto = walletService.updateWalletBalance(user_Id, amount);
//		return walletDto;
//	}


}
