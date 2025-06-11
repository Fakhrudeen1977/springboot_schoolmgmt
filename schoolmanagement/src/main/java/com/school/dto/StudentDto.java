package com.school.dto;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class StudentDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long studentId;
	private String studentName;
	private String fatherName;
	private String gender;
	private Date dateOfBirth;
	private String className;
	private Long classId;
	private Long bloodId;
	private String bloodGroupName;
	private String mobileNumber;
	private String contactAddress;
	private int photoNumber;
	private String imageFileName;
	private String imageType;
	private byte[] imageData;	
	private String message;
	
	
	public StudentDto() {

	}
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}



	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public int getPhotoNumber() {
		return photoNumber;
	}

	public void setPhotoNumber(int photoNumber) {
		this.photoNumber = photoNumber;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
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

	
	

}
