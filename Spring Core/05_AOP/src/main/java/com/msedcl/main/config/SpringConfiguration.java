package com.msedcl.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.msedcl.main.aspects.LoggingAspect;
import com.msedcl.main.repository.UserRepository;
import com.msedcl.main.service.UserService;

@Configuration
//@ComponentScan(basePackages = "com.msedcl.main")
@EnableAspectJAutoProxy
public class SpringConfiguration {

	// Spring Configuration
	// a. Annotation Configuration - done
	// b. Java Configuration 

	@Bean
	UserRepository getUserRepository() {
		System.out.println("SpringConfiguration Class - getUserRepository()");
		return new UserRepository();
	}
	
	@Bean
	UserService getUserService() {
		System.out.println("SpringConfiguration Class - getUserService()");
		return new UserService(getUserRepository());
		
	}

	@Bean
	LoggingAspect getLoggingAspect() {
		System.out.println("SpringConfiguration Class - getLoggingAspect()");
		return new LoggingAspect();
	}
}
