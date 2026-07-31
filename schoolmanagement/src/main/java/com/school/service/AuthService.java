package com.school.service;

import org.springframework.stereotype.Component;

import com.school.dto.UserDto;
import com.school.exception.EmailAlreadyExistsException;
import com.school.exception.UsernameAlreadyExistsException;
@Component
public interface AuthService {	
	
	public UserDto saveUserWithRoles(UserDto userDto,Long[] userRoles) throws UsernameAlreadyExistsException, EmailAlreadyExistsException;	

}
