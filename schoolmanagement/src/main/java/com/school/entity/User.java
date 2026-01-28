package com.school.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(	name = "Users",
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "User_Name"),
	@UniqueConstraint(columnNames = "Email") 
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String name;
	private String userName;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();
	
	private String imageFileName;
	private String imageType;
	private byte[] imageData;	

	public User() {

	}
	
	
	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	@SequenceGenerator(sequenceName = "Users_seq", allocationSize = 1, name = "USERS_SEQ")
		
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name = "Name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "User_Name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "Email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "User_Roles", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "User_Id"), inverseJoinColumns = @JoinColumn(name = "Role_Id", referencedColumnName = "Role_Id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Column(name = "IMAGE_NAME") 
	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@Column(name = "IMAGE_TYPE")
	public String getImageType() {
		return imageType;
	}


	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Lob
	@Column(name = "IMAGE_DATA")
	public byte[] getImageData() {
		return imageData;
	}


	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
