package com.school;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SchoolmanagementApplication  {
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolmanagementApplication.class);

	public static void main(String[] args) {
		logger.info("Spring Boot Application Loading successfully");
		
		SpringApplication.run(SchoolmanagementApplication.class, args);	
		
				
	}	


}
