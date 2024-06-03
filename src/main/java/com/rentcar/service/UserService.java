package com.rentcar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.entity.User;
import com.rentcar.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	public void addUserDetails(int customerId, String username, String password) {
		User user = new User(customerId,username,password);
		userRepository.save(user);
	}

	public boolean authenticate(String username, String password) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return user.get().getPassword().equals(password);
		}
		return false;
	}

	public boolean isUsernameExists(String username) {
		return userRepository.findByUsername(username).isPresent();
	}

}
