package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication

public class SchoolmanagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(SchoolmanagementApplication.class, args);
		
		
		
				
	}
	


	  @Override
	    public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SchoolmanagementApplication.class);
	    } 
}
