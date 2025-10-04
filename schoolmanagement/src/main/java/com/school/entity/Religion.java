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
@Table(name="RELIGION")
public class Religion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long religionId;
	private String religionName;
	
	@Id
	@Column(name = "RELIGION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELIGION_SEQ")
	@SequenceGenerator(sequenceName = "RELIGION_SEQ", allocationSize = 1, name = "RELIGION_SEQ")
	public Long getReligionId() {
		return religionId;
	}
	public void setReligionId(Long religionId) {
		this.religionId = religionId;
	}
	
	@Column(name="RELIGION_NAME")
	public String getReligionName() {
		return religionName;
	}
	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}

}
