package com.school.dto;

import java.io.Serializable;

public class LeavingReasonDto implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long leavingReasonId;
    private String leavingReasonValue;
	public Long getLeavingReasonId() {
		return leavingReasonId;
	}
	public void setLeavingReasonId(Long leavingReasonId) {
		this.leavingReasonId = leavingReasonId;
	}
	public String getLeavingReasonValue() {
		return leavingReasonValue;
	}
	public void setLeavingReasonValue(String leavingReasonValue) {
		this.leavingReasonValue = leavingReasonValue;
	}
	
}
