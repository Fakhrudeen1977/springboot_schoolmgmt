package com.school.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Refresh_Token")
public class RefreshToken implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private User user;
	private String token;
	private Instant expiryDate;

	public RefreshToken() {

	}
	
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REFRESH_TOKEN_SEQ")
	@SequenceGenerator(sequenceName = "REFRESH_TOKEN_SEQ", allocationSize = 1, name = "REFRESH_TOKEN_SEQ")
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@OneToOne
	 @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="Token ")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Column(name="Expiry_Date")
	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

}
