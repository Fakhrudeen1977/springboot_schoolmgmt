package com.school.dto;

import java.io.Serializable;

public class ClassDetailsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long classId;
	private String className;
	
	public ClassDetailsDto() {
		
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
