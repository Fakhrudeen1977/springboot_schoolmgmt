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
@Table(name="Class_Details")
public class ClassDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long classId;
	private String className;
	
	public ClassDetails() {
		
	}
	
	
	@Id
	@Column(name = "Class_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASS_DETAILS_SEQ")
	@SequenceGenerator(sequenceName = "Class_Details_seq", allocationSize = 1, name = "CLASS_DETAILS_SEQ")
	
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	
	@Column(name="Class_Name")
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
