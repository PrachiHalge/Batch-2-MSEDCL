package com.msedcl.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.msedcl.main.config.SpringConfiguration;
import com.msedcl.main.repository.UserRepository;
import com.msedcl.main.service.UserService;

//https://notepad.pw/msedcl
public class UserMain {
	public static void main(String[] args) {
		System.out.println("main start");

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);

		UserService userService = applicationContext.getBean(UserService.class);

		userService.createUser("Reema");

		System.out.println();

		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		userRepository.createUser("Seema");

		applicationContext.close();
		System.out.println("main end");
	}
}
