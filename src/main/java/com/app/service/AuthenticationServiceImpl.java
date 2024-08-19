package com.app.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.BadRequestException;
import com.app.dto.AuthResponseDto;
import com.app.dto.AuthUserDto;
import com.app.dto.UserDto;
import com.app.entities.AuthUser;
import com.app.repository.AuthenticationRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationRepository authenticationRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void register(AuthUserDto authUserDto) {
		
		Optional<AuthUser> user = authenticationRepository.findByEmail(authUserDto.getEmail());
		if(user.isPresent()) {
			throw new BadRequestException("User already registered");
		}
		
		AuthUser authUser = convertToEntity(authUserDto);
		authenticationRepository.save(authUser);
		UserDto userDto = new UserDto();
		userDto.setEmail(authUserDto.getEmail());
		userDto.setPhoneNo(authUserDto.getPhoneNo());
		userDto.setUserName(authUserDto.getPhoneNo());
		UserDto savedUserDto = userService.addUser(userDto);
		if(Objects.isNull(savedUserDto.getUserID())) {
			throw new BadRequestException("User not registered");
		}
	}

	@Override
	public AuthResponseDto login(AuthUserDto authUserDto) {
		
		Optional<AuthUser> optionalAuthUser = authenticationRepository.findByEmail(authUserDto.getEmail());
		if(optionalAuthUser.isEmpty())
			throw new BadRequestException("Invalid user does not exist");
		AuthUser authUser = optionalAuthUser.get();
		if(!authUser.getPassword().equals(authUserDto.getPassword())) {
			throw new BadRequestException("Invalid username/password");
		}
	
		return convertToResponseDto(authUser, userService.retrieveUserByEmail(authUser.getEmail()));
	}
	
	private AuthUser convertToEntity(AuthUserDto authUserDto) {
		AuthUser authUser = new AuthUser();
		authUser.setEmail(authUserDto.getEmail());
		authUser.setPassword(authUserDto.getPassword());
		authUser.setAdmin('N');
		return authUser;
	}

	private AuthResponseDto convertToResponseDto(AuthUser authUser, UserDto userDto) {
		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setEmail(userDto.getEmail());
		authResponseDto.setUserName(userDto.getUserName());
		authResponseDto.setAdmin(authUser.getAdmin());
		authResponseDto.setUserId(userDto.getUserID());
		return authResponseDto;
	}
}
