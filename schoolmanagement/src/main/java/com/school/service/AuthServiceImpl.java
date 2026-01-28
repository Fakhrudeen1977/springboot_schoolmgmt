package com.school.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.UserDto;
import com.school.entity.Role;
import com.school.entity.User;
import com.school.mapper.OrikaBeanMapper;
import com.school.repository.RoleRepository;
import com.school.repository.UserRepository;
@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	

	@Override
	@Transactional
	public UserDto saveUser(UserDto userDto,String[] userRoles) {
		
		
		UserDto savedUserDto=null;	
		Set<Role> roles = new HashSet<>();		
		User user= mapper.map(userDto, User.class);				
		
		String[] roleArr = userRoles;

		if (roleArr == null) {

			roles.add(roleRepository.findByRoleName("User"));
		}

		for (String role : roleArr) {

			switch (role) {
			case "Admin": {

				roles.add(roleRepository.findByRoleName("Admin"));

				break;
			}

			case "HR": {

				roles.add(roleRepository.findByRoleName("HR"));

				break;
			}
			case "User": {

				roles.add(roleRepository.findByRoleName("User"));
				break;
			}

			default:
				//return ResponseEntity.badRequest().body("Specified role not found");
				return null;
			}
			System.out.println("Inside Loop");
		}
		
		user.setRoles(roles);

		user= userRepository.saveAndFlush(user);
		savedUserDto  = mapper.map(user, UserDto.class);
		return savedUserDto;

		
		
		
	}

}
