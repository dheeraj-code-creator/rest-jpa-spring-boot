package com.spring.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.app.entity.User;
import com.spring.rest.app.service.UserService;

@RestController
@RequestMapping(value = "/userinfo")
public class UserController {

	@Autowired
	private UserService userService;

	// get all users info
	@GetMapping(value = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUserInfo();
	}
	
	@GetMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
	public String message(){
		return "Hello docker!!!";
	}

}
