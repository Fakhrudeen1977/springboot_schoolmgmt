package com.school.dto;

import java.io.Serializable;

public class BloodGroupDto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long bloodId;
	private String bloodGroupName;
	private boolean activeStatus;
	
	public BloodGroupDto() {
		
	}
	
	public Long getBloodId() {
		return bloodId;
	}

	public void setBloodId(Long bloodId) {
		this.bloodId = bloodId;
	}
	
	
	
	public String getBloodGroupName() {
		return bloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	

	


}
