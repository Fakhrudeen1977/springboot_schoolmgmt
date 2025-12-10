package com.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	 @GetMapping("/home")
	 public ResponseEntity<String> getHomePage()
	 {
		 System.out.println("Welcome to Home Page");
		 
		 return new ResponseEntity<String>("Welcome to Home Page",HttpStatus.OK);
	 }
	
}
