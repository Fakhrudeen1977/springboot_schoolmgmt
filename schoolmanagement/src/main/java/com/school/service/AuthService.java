package com.school.service;

import org.springframework.stereotype.Component;

import com.school.dto.UserDto;
@Component
public interface AuthService {
	
	public UserDto saveUser(UserDto userDto,String[] userRoles) ;	

}
