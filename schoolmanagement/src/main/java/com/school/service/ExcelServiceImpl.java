package com.school.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.school.entity.Student;
import com.school.repository.StudentRepository;
import com.school.util.ExcelUtility;

@Service
public class ExcelServiceImpl implements ExcelService {
	
  @Autowired
  private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public void save(MultipartFile file) {
		 try {
			  System.out.println("Reached ExcelService"+" "+file.getInputStream());
		      List<Student> studentList = ExcelUtility.excelToStudentList(file.getInputStream());
		      studentRepository.saveAll(studentList);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		
	}

}
