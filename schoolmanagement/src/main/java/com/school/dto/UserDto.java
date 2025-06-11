package com.school.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.school.entity.Role;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String name;
	private String userName;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
	
	public UserDto() {
		
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
