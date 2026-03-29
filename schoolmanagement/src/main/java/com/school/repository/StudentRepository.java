package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.dto.StudentViewDto;
import com.school.entity.Student;
import com.school.queryconstant.Querys;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Modifying      // to mark delete or update query
 	//@Query(value = Querys.DELETE_BY_STUDENTID)       
 	void deleteByStudentId(@Param("studentId") Long studentId);
 	
 			
	@Query(value = Querys.FIND_MALE_STUDENTS)       
 	List<Student> getMaleStudentList();
	
	
	@Query(value = Querys.FIND_ALL_STUDENTS)       
 	List<StudentViewDto> getStudentList();
 	
 	
	
	@Query(value = Querys.FIND_FEMALE_STUDENTS)       
 	List<Student> getFemaleStudentList();
		
	
	
	@Query(value = Querys.GET_BIRTHDAY_BABIES)
 	List<Student> getBirthBabiesList();
	
	
	
	@Query(value = Querys.COUNT_BY_PHOTONUMBER)       
 	int countByPhotoNumber(@Param("photoNumber") int photoNumber);
	
	
	@Query(value = Querys.GET_ALL_STUDENTS_BYCLASSID)       
 	List<Student> getStudentListByClassId(@Param("classId") Long classId);

	

	 	
	 	

}
