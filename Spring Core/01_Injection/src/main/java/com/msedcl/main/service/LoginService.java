package com.msedcl.main.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.msedcl.main.domain.LoginDetails;

@Component
public class LoginService {

	public LoginService() {
		System.out.println("Default Constructor Called");
	}

	public boolean validate(LoginDetails loginDetails) {
		if (loginDetails.getLoginId().equals("ADMIN") && loginDetails.getPassword().equals("Admin@123"))
			return true;
		else
			return false;
	}
}
