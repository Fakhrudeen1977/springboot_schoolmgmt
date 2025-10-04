package com.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	 @GetMapping("/home")
	 public void getHomePage() {
		 System.out.println("Welcome to Home Page");
	 }
	
}
