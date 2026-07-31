package com.school.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.UserDto;
import com.school.entity.Role;
import com.school.entity.User;
import com.school.exception.EmailAlreadyExistsException;
import com.school.exception.UsernameAlreadyExistsException;
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
	public UserDto saveUserWithRoles(UserDto userDto, Long[] userRoles) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {

		if (userRepository.existsByUserName(userDto.getUserName())) {
			throw new UsernameAlreadyExistsException("Username is already taken");
		}

		if (userRepository.existsByEmail(userDto.getEmail())) {
			throw new EmailAlreadyExistsException("Email is already taken");
		}
		

		User user = mapper.map(userDto, User.class);

		Set<Role> roles = new HashSet<>();

		// If no role is selected, assign default User role
		if (userRoles == null || userRoles.length == 0) {

			Role defaultRole = roleRepository.findByRoleName("User");

			if (defaultRole == null) {
				throw new RuntimeException("Default role 'User' not found.");
			}

			roles.add(defaultRole);

		} else {

			for (Long roleId : userRoles) {

				Role role = roleRepository.findByRoleId(roleId);

				if (role == null) {
					throw new RuntimeException("Role not found with id : " + roleId);
				}

				roles.add(role);
			}
		}

		user.setRoles(roles);

		User savedUser = userRepository.save(user);

		return mapper.map(savedUser, UserDto.class);

	}

}
