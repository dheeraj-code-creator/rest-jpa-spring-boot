package com.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.app.entity.User;
import com.rest.app.repository.UserRepository;
import com.rest.app.service.UserService;

@RestController
@RequestMapping(value = "/userinfo")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	// get all users info
	@GetMapping(value = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers() {
		return userService.getAllUserInfo();
	}

	// get for particular user
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable("userId") String userId) {
		return userService.getUserById(userId);
	}

	// update existing user
	@PutMapping(value = "/update/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@PathVariable("userId") String userId, @RequestBody User users) {
		return userService.updateUserInfo(userId, users);

	}

	// create new user
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User users) {
		return userService.createNewUser(users);
	}

	// delete users
	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable(value = "userId") String userId) {
		userRepository.deleteById(userId);
		// return userService.deleteUserById(userId);

	}

}
