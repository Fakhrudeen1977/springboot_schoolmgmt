package com.school.dto;

import java.io.Serializable;

public class ReligionDto implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Long religionId;
	 private String religionName;
	 
	 public Long getReligionId() {
		 return religionId;
	 }
	 public void setReligionId(Long religionId) {
		 this.religionId = religionId;
	 }
	 public String getReligionName() {
		 return religionName;
	 }
	 public void setReligionName(String religionName) {
		 this.religionName = religionName;
	 }

}
