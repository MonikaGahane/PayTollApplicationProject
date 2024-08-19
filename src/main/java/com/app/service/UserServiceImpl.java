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
public class UserServiceImpl implements UserService {

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
		walletService.createZeroBalanceWallet(savedUser.getUserID());  // if new user added then at that moment wallet also created... so for that purpose we are calling createZeroBalanceWallet() method.
		return objectMapper.convertValue(savedUser, UserDto.class);
	}

	@Override
	public UserDto retrieveUser(Long user_ID) {
		Optional<User> optUser = userRepository.findById(user_ID);
		if (optUser.isEmpty()) { 
			throw new ResourceNotFoundException("User not available for UserId:"+ user_ID);
		}
		User user = optUser.get();
		UserDto userDto = objectMapper.convertValue(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto retrieveUserByEmail(String email) {
		Optional<User> optUser = userRepository.findByEmail(email);
		if (optUser.isEmpty()) { 
			throw new ResourceNotFoundException("User not available for :"+ email);
		}
		User user = optUser.get();
		UserDto userDto = objectMapper.convertValue(user, UserDto.class);
		return userDto;
	}


}
