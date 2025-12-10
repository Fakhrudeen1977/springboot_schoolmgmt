package com.school.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentDto;
import com.school.entity.Student;
import com.school.entity.StudentImage;
import com.school.exception.PhotoNumberExistException;
import com.school.exception.StudentIdNotFoundException;
import com.school.mapper.OrikaBeanMapper;
import com.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
 

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	private int photoNumberCount=0;

    
	@Override
	@Transactional
	public StudentDto saveStudent(StudentDto studentDto) throws PhotoNumberExistException  {
		
		
		StudentDto savedDto=null;			
		Student student= mapper.map(studentDto, Student.class);				
		
		if(!checkPhotoNumberExistOrNot(student.getPhotoNumber())) {
			System.out.println("Saveed Studetn Information");	
			student= studentRepository.saveAndFlush(student);
			savedDto  = mapper.map(student, StudentDto.class);
			return savedDto;
		}
		
		else
			throw new PhotoNumberExistException("Photo Number"+" "+studentDto.getPhotoNumber()+" "+ "Already Exist");
					
		
	}
	
	
	@Override
	@Transactional
	public StudentDto updateStudent(StudentDto studentDto) throws PhotoNumberExistException  {
		
		
		StudentDto savedDto=null;				
		Student student= mapper.map(studentDto, Student.class);		
		StudentImage studentImage=student.getStudentImage();
		
		if(checkPhotoNumberExistOrNot(student.getPhotoNumber()) && student.getStudentId()!=null) {
			
			System.out.println("Update Studennt PhotoNumber Exist"+" "+photoNumberCount);
				student= studentRepository.saveAndFlush(student);
				
				
				savedDto  = mapper.map(student, StudentDto.class);
			
			
			return savedDto;
		}
		
		else if(!checkPhotoNumberExistOrNot(student.getPhotoNumber())) {
			System.out.println("Update Student PhotoNumber not Exist"+" "+photoNumberCount);
			
			student= studentRepository.saveAndFlush(student);
			savedDto  = mapper.map(student, StudentDto.class);
			return savedDto;
		}
		
		
		else
			throw new PhotoNumberExistException("Photo Number"+" "+studentDto.getPhotoNumber()+" "+ "Already Exist"); 	
		
		
		
	
	}
	
	
	public boolean checkPhotoNumberExistOrNot(int photoNumber) {
		System.out.println("Photo Number displayed"+" "+photoNumber);
		int result=0;
		boolean isFlag=false;
		result=studentRepository.countByPhotoNumber(photoNumber);
		photoNumberCount=result;
		System.out.println("Photo Number Exist Count"+" "+photoNumberCount);
		if(result>0) 
			isFlag=true;
		else
		isFlag=false;
		
		System.out.println("Photo Number cOUNT"+" "+result+" ISFlag Value"+isFlag);

		return isFlag;
	}	
	
	
	@Override
	public List<StudentDto> getStudentList() {				
		System.out.println("Reached GetStudent List");
		//List<StudentViewDto> studentList=studentRepository.getStudentList();	
		
		List<Student> studentList=studentRepository.findAll();
		//StudentDto savedDto  = mapper.map(studentList, StudentDto.class);
		
		List<StudentDto> savedDto=mapper.mapAsList(studentList, StudentDto.class);
		return savedDto;
		
	}
	public boolean checkStudentIdExistOrNot(Long studentId) {
		boolean isFlag=false;
		Optional<Student> option = studentRepository.findById(studentId);

		if (option.isPresent()) {
			return isFlag=true;
		}

		return isFlag;
	}	
	
	
	
	@Override
	public StudentDto getStudentById(Long studentId) throws StudentIdNotFoundException{
		
		Student  student= studentRepository.findById(studentId).orElseThrow( ()-> new StudentIdNotFoundException("Student Id:"+" "+studentId+" "+ "Does not  Exist")); 	
	
		StudentDto savedDto  = mapper.map(student,  StudentDto.class);
				
	    return savedDto;
		
		
	}
	
	
	
	@Override
	@Transactional
	public void  deleteByStudentId(Long studentId)  {	
			 
			 if(this.checkStudentIdExistOrNot(studentId)) 
				  studentRepository.deleteByStudentId(studentId);		 

}
	/*
	@Override
	public List<Student> getMaleStudentList() {
		return studentRepository.getMaleStudentList();
		
	}
	@Override
	public List<Student> getFemaleStudentList() {
		// TODO Auto-generated method stub
		return studentRepository.getFemaleStudentList(); 
	}
	
	@Override
	public List<Student> getBirthBabiesList() {
		
		return studentRepository.getBirthBabiesList();
		
	}
	
	@Override
	public Optional<Student> getImageById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId);
	}
	*/


}
