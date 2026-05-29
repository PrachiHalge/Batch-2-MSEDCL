package com.msedcl.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetingsapi")
public class HelloWorldController {

	// url = http://localhost:8080/greetingsapi/greet
	// method = GET
	@GetMapping("greet")
	public String showMessage() {
		return "Java is best programming language";
	}

	// url = http://localhost:8080/greetingsapi/process/{data}
	// method = GET
	@GetMapping("process/{data}")
	public String processData(@PathVariable String data) {
		return data.toUpperCase();
	}

	// url = http://localhost:8080/greetingsapi/display
	// method = POST
	@PostMapping("display")
	public String print() {
		return "Testing post mapping!";
	}
}
