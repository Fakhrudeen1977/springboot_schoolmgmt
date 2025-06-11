package com.school.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.entity.User;
import com.school.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	  UserRepository userRepository;
	
	  @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByUserName(username)
	                    .orElseThrow(() -> new UsernameNotFoundException("User with "
	                        + "user name "+ username + " not found"));
	    
	    return UserDetailsImpl.build(user);
	  }
}
