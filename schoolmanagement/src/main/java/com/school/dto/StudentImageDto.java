package com.school.dto;

import java.io.Serializable;
import com.school.entity.Student;
public class StudentImageDto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long imageId;
	private String imageFileName;
	private String imageType;
	private byte[] imageData;
	private Student student;
	
	public StudentImageDto() {
		
	}
	
	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
