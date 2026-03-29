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
@Table(name="Blood_Group")
public class BloodGroup implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long bloodId;
	private String bloodGroupName;
	private boolean activeStatus;
	
	public BloodGroup() {
		
	}	
	
	
	@Id
	@Column(name = "Blood_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLOOD_GRP_SEQ")
	@SequenceGenerator(sequenceName = "Blood_Grp_seq", allocationSize = 1, name = "BLOOD_GRP_SEQ")
		
	
	public Long getBloodId() {
		return bloodId;
	}
	public void setBloodId(Long bloodId) {
		this.bloodId = bloodId;
	}
	

	@Column(name="BLOODGRP_NAME")
	public String getBloodGroupName() {
		return bloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}
	
	@Column(name="Is_Active") 
	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	
	
	
}
