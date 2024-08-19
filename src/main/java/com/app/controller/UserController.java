package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	//API for adding new user
	@PostMapping("/add")
	public UserDto addUser(@RequestBody UserDto userDto) {
		return userService.addUser(userDto);
	}
	
	//API for retrieve user
	@GetMapping("/retrieve/{user_id}")
	public UserDto retrieveUser(@PathVariable Long user_id) {
		return userService.retrieveUser(user_id);
	}
	
	
}
