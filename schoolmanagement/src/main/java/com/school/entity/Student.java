package com.school.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Student_Detail")
public class Student implements Serializable{
	
	 	
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
	    private String imageFileName;
		private String imageType;
		private byte[] imageData;	 
	    private StudentImage studentImage;
	   	    
	    public Student() {	    	
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
		
		@OneToOne(mappedBy="student",cascade =CascadeType.ALL,orphanRemoval = true)
		@JsonManagedReference
		public StudentImage getStudentImage() {
			return studentImage;
		}

		public void setStudentImage(StudentImage studentImage) {
			
			this.studentImage = studentImage;
			if(studentImage!=null)
			this.studentImage.setStudent(this);
			
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

		@Column(name="EMAIL")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Column(name="MOTHER_NAME") 
		public String getMotherName() {
			return motherName;
		}

		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}
		@Column(name="FATHERMOBILE_NUMBER")
		public String getFatherMobileNumber() {
			return fatherMobileNumber;
		}

		public void setFatherMobileNumber(String fatherMobileNumber) {
			this.fatherMobileNumber = fatherMobileNumber;
		}
        
		@Column(name="MOTHERMOBILE_NUMBER")
		public String getMotherMobileNumber() {
			return motherMobileNumber;
		}

		public void setMotherMobileNumber(String motherMobileNumber) {
			this.motherMobileNumber = motherMobileNumber;
		}

		@Column(name="AADHAR_NUMBER")
		public String getAadharCardNumber() {
			return aadharCardNumber;
		}

		public void setAadharCardNumber(String aadharCardNumber) {
			this.aadharCardNumber = aadharCardNumber;
		}
		
		@Column(name="RELIGION_ID")
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


         @Transient
		public String getImageFileName() {
			return imageFileName;
		}


		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}

		  @Transient
		public String getImageType() {
			return imageType;
		}


		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		  @Transient
		public byte[] getImageData() {
			return imageData;
		}


		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

       



		
		
	
		

			
		
		 
	
}
