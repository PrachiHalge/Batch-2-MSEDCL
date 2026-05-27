package com.msedcl.main.service;

import com.msedcl.main.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public void createUser(String name) {
		userRepository.createUser(name);
	}
}
