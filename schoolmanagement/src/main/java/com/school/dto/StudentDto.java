package com.school.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long studentId;
	private String studentName;
	private String fatherName;
	private String motherName;
	private String gender;
	private Date dateOfBirth;
	private String className;
	private Long classId;
	private Long bloodId;
	private String bloodGroupName;
	private String fatherMobileNumber;
	private String motherMobileNumber;
	private String aadharCardNumber;
	private String contactAddress;
	private int photoNumber;
	private String imageFileName;
	private String imageType;
	private byte[] imageData;	
	
	private String email;		
	private Long religionId;
	private String religionName;
	private StudentImageDto studentImage;
	
	
	public StudentDto() {
				
	}	

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {		
		this.studentId = studentId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}

	public String getMotherMobileNumber() {
		return motherMobileNumber;
	}

	public void setMotherMobileNumber(String motherMobileNumber) {
		this.motherMobileNumber = motherMobileNumber;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public StudentImageDto getStudentImage() {
		
		return studentImage;
	}

	public void setStudentImage(StudentImageDto studentImage) {
		
		this.studentImage = studentImage;
		
		
	}

	
	
	
	

}
