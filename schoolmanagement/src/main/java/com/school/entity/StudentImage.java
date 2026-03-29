package com.school.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "STUDENT_IMAGE")

public class StudentImage implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long imageId;
	private String imageFileName;
	private String imageType;
	private byte[] imageData;
	private Student student;
	
	public StudentImage() {
		
	}
	

	@Id
	@Column(name = "IMAGE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_IMAGE_SEQ")
	@SequenceGenerator(sequenceName = "STUDENT_IMAGE_SEQ", allocationSize = 1, name = "STUDENT_IMAGE_SEQ") 
	public Long getImageId() {
		return imageId;
	}


	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	   
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="STUDENT_ID")
	@JsonBackReference
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	@Lob
	@Column(name = "IMAGE_DATA")
	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
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

}
