package com.school.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="Role")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long roleId; 
	private String roleName;
		
	public Role() {
		
	}
	
	
	@Id
	@Column(name = "Role_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	@SequenceGenerator(sequenceName = "Role_seq", allocationSize = 1, name = "ROLE_SEQ")
		
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name="Role_Name")
	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
