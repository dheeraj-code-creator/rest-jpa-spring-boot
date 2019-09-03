package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		User userObj1 = new User("111", "User111");
		User userObj2 = new User("222", "User222");
		userList.add(userObj1);
		userList.add(userObj2);
		userRepository.saveAll(userList);
		return userRepository.findAll();
	}

	public User getUserById(String userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateUserInfo(String userId, User users) {
		User existingUserId = userRepository.findById(userId).orElse(null);
		existingUserId.setUserId(users.getUserId());
		existingUserId.setUserName(users.getUserName());
		return userRepository.save(existingUserId);
	}

	public User createNewUser(User users) {
		User objUser = new User();
		objUser.setUserId(users.getUserId());
		objUser.setUserName(users.getUserName());
		return userRepository.save(objUser);
	}

}
