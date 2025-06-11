package com.school.queryconstant;

public class Querys {
	
	public static final String DELETE_BY_STUDENTID="DELETE FROM Student s  WHERE s.studentId = :studentId";
	
	public static final String FIND_ALL_STUDENTS="SELECT s  FROM  Student s ";
	
	//public static final String GET_ALL_STUDENTS_BYCLASSID="SELECT s  FROM  Student s  WHERE s.classId = :classId ";
	
	public static final String GET_ALL_STUDENTS_BYCLASSID="SELECT s  FROM  Student s  WHERE s.classId = :classId ";
	
	public static final String FIND_MALE_STUDENTS="SELECT s  FROM  Student s  WHERE s.gender = 'Male'";
		
	public static final String FIND_FEMALE_STUDENTS="SELECT s  FROM  Student s  WHERE s.gender = 'Female'";
			
	public static final String GET_BIRTHDAY_BABIES="SELECT s FROM Student s WHERE MONTH(s.dateOfBirth) = MONTH(SYSDATE)";  
		
	public static final String DELETE_BY_BLOODGROUPID="DELETE FROM BloodGroup b  WHERE b.bloodId = :bloodGroupId";
	
	public static final String COUNT_BY_PHOTONUMBER="SELECT COUNT(*) FROM Student s where s.photoNumber=:photoNumber";
	
	
	public static final String DELETE_ROLES_BYUSERID="DELETE FROM JWT_USER_ROLES WHERE User_Id =:userId";
	

	public static final String DELETE_BYUSERID="DELETE FROM JWT_USER WHERE User_Id =:userId";
	
	
	
}


