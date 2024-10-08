package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthResponseDto;
import com.app.dto.AuthUserDto;
import com.app.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@PostMapping("/register")
	public ResponseEntity registerUser(@RequestBody AuthUserDto authUserDto) {
		authenticationService.register(authUserDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody AuthUserDto authUserDto) {
		AuthResponseDto userDto = authenticationService.login(authUserDto);
		return new ResponseEntity<AuthResponseDto>(userDto , HttpStatus.OK);
	}
	
	

}
