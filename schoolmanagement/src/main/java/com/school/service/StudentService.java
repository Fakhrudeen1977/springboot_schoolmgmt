package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.school.dto.StudentDto;
import com.school.entity.Student;
import com.school.exception.PhotoNumberExistException;
import com.school.exception.StudentNotFoundException;

@Component
public interface StudentService {
	
	public StudentDto saveStudent(StudentDto studentDto) throws PhotoNumberExistException ;	
	public StudentDto updateStudent(StudentDto studentDto) throws PhotoNumberExistException ;
		
	public List<StudentDto> getStudentList();
	
	public  Optional<StudentDto> getStudentById(Long studentId);
	public void deleteByStudentId(Long studentId) throws StudentNotFoundException;
	public List<Student> getMaleStudentList();
	public List<Student> getFemaleStudentList();
	public List<Student> getBirthBabiesList();
	public  Optional<Student> getImageById(Long studentId);
	
	
	
	
	
}
