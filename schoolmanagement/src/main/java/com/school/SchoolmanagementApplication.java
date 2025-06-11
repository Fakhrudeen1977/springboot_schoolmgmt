package com.school;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication

public class SchoolmanagementApplication extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolmanagementApplication.class);

	public static void main(String[] args) {
		logger.info("Spring Boot Application Loading successfully");
		
		SpringApplication.run(SchoolmanagementApplication.class, args);	
		
		
				
	}
	


	  @Override
	    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SchoolmanagementApplication.class);
	    } 
}
