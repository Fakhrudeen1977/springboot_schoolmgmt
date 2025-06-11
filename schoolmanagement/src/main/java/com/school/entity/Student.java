package com.school.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Student_Detail")
public class Student implements Serializable{
	
	 	

		private static final long serialVersionUID = 1L;
		private Long studentId;
	  	private String studentName;
	    private String fatherName;
	    private String gender;
	    private Date dateOfBirth;
	    private Long classId;
	    private String className;
	    private Long bloodId;
	    private String bloodGroupName;
	    private String mobileNumber;
	    private String contactAddress;
	    private int photoNumber;	    
	    private String imageFileName;
	    private String imageType;
	    private byte[] imageData;

	    
	    public Student() {
	    	
	    }
	    
	    public Student(String imageName,String imageType,byte[] imageData) {
	    	this.imageFileName=imageFileName;
	    	this.imageType=imageType;
	    	this.imageData=imageData;
	    }
	    
		
		
		@Id
		@Column(name="STUDENT_ID")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ")
		@SequenceGenerator(sequenceName = "Student_seq", allocationSize = 1, name = "STUDENT_SEQ")
			
		
		
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		@Column(name="STUDENT_NAME")
		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		
		@Column(name="FATHER_NAME")
		public String getFatherName() {
			return fatherName.toUpperCase();
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		@Column(name="GENDER")
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		@Column(name="CLASS_NAME")
		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}
	
				
		@Column(name="DOB")
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}		
		
		@Column(name="MOBILE_NUMBER")
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		@Column(name="CONTACT_ADDRESS")
		public String getContactAddress() {
			return contactAddress.toUpperCase();
		}
		public void setContactAddress(String contactAddress) {
			this.contactAddress = contactAddress;
		}
		
		@Column(name="PHOTO_NUMBER") 
		public int getPhotoNumber() {
			return photoNumber;
		}

		public void setPhotoNumber(int photoNumber) {
			this.photoNumber = photoNumber;
		}

		@Lob
		@Column(name = "IMAGE_DATA")
		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}
		@Column(name="IMAGE_NAME")
		public String getImageFileName() {
			return imageFileName;
		}

		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
	
		@Column(name="IMAGE_TYPE")
		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		@Column(name="CLASS_ID")
		public Long getClassId() {
			return classId;
		}

		public void setClassId(Long classId) {
			this.classId = classId;
		}
		@Column(name="BLOOD_ID")
		public Long getBloodId() {
			return bloodId;
		}

		public void setBloodId(Long bloodId) {
			this.bloodId = bloodId;
		}
		@Column(name="BLOOD_GROUP")
		public String getBloodGroupName() {
			return bloodGroupName;
		}

		public void setBloodGroupName(String bloodGroupName) {
			this.bloodGroupName = bloodGroupName;
		}

		
		
	
		

			
		
		 
	
}
