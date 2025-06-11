package com.school.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200")
public class ValidateJwtToken {

	private final String jwtTokenSecret = "mySecret1234567890123456789012345678901234567890";
	private static final Logger logger = LoggerFactory.getLogger(ValidateJwtToken.class);

	@GetMapping("/validateToken/{token}")

	public boolean validateToken(@PathVariable String token) {
		try {
			System.out.println("Token Received" + " " + token);
			Jwts.parserBuilder().setSigningKey(jwtTokenSecret).build().parseClaimsJws(token).getBody();
			return true;
		}

		catch (Exception e) {
			System.out.println("Invalid JWT" + e.getMessage());
		}
		return false;

	}

	public Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(jwtTokenSecret).build().parseClaimsJws(token).getBody();
	}



	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
		headers.forEach((key, value) -> {
			//LOG.info(String.format("Header '%s' = %s", key, value));
		    System.out.println(String.format("Header '%s' = %s", key, value));
		});

		return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
	}
}
