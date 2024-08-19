package com.app.service;

import com.app.dto.AuthResponseDto;
import com.app.dto.AuthUserDto;
import com.app.dto.UserDto;

public interface AuthenticationService {
	
	public void register(AuthUserDto authUser);
	
	public AuthResponseDto login(AuthUserDto authUser);

}
