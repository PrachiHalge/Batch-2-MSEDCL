package com.msedcl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.msedcl.main.domain.LoginDetails;
import com.msedcl.main.repository.LoginRepository;

@Service
public class LoginService {

	private LoginRepository loginRepository;

//	public LoginService() {
//		System.out.println("Default Constructor Called - LoginService");
//	}

	public LoginService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
		System.out.println("Overloaded Constructor Called - LoginService");
	}

	public LoginRepository getLoginRepository() {
		System.out.println("getLoginRepository()");
		return loginRepository;
	}

	public void setLoginRepository(LoginRepository loginRepository) {
		System.out.println("setLoginRepository()");
		this.loginRepository = loginRepository;
	}

	public boolean validate(LoginDetails loginDetails) {
		return loginRepository.validate(loginDetails);
	}

	public boolean addNewUser(LoginDetails loginDetails) {
		return loginRepository.addNewUser(loginDetails);
	}

}
