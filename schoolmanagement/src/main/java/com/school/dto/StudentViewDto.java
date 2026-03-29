package com.school.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentViewDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long studentId;
  	private String studentName;
    private String fatherName;
    private String motherName;
    private String gender;
    private Date dateOfBirth;
    private Long classId;
    private String className;
    private Long bloodId;
    private String bloodGroupName;
    private String fatherMobileNumber;
    private String motherMobileNumber;
    private String aadharCardNumber;
    private String contactAddress;
    private int photoNumber;	   
    private String email;
    private Long religionId;
    private String religionName;
		
	public StudentViewDto(Long studentId, String studentName, String fatherName, String motherName, String gender,
			Date dateOfBirth, Long classId, String className, Long bloodId, String bloodGroupName,
			String fatherMobileNumber, String motherMobileNumber, String aadharCardNumber, String contactAddress,
			int photoNumber, String email, Long religionId, String religionName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.classId = classId;
		this.className = className;
		this.bloodId = bloodId;
		this.bloodGroupName = bloodGroupName;
		this.fatherMobileNumber = fatherMobileNumber;
		this.motherMobileNumber = motherMobileNumber;
		this.aadharCardNumber = aadharCardNumber;
		this.contactAddress = contactAddress;
		this.photoNumber = photoNumber;
		this.email = email;
		this.religionId = religionId;
		this.religionName = religionName;
	}

	public StudentViewDto() {
		
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


	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	
	
	public int getPhotoNumber() {
		return photoNumber;
	}

	public void setPhotoNumber(int photoNumber) {
		this.photoNumber = photoNumber;
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
