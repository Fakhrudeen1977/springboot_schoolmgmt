package com.school.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.school.dto.StudentDto;
import com.school.dto.StudentImageDto;
import com.school.exception.PhotoNumberExistException;
import com.school.service.StudentService;
import com.school.util.ImageUtil;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")

public class StudentController {

	@Autowired
	private StudentService studentService;	
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class); 
	
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentDto> saveStudent(
			@RequestParam String studentName,
			@RequestParam String fatherName,
			@RequestParam String motherName,
			@RequestParam String gender,
			@RequestParam String dateOfBirth, 
			@RequestParam Long classId,
			@RequestParam String className,
			@RequestParam Long bloodId,
			@RequestParam Long religionId,
			@RequestParam String religionName,
			@RequestParam String bloodGroupName,
			@RequestParam String fatherMobileNumber, 
			@RequestParam String motherMobileNumber, 
			@RequestParam String aadharCardNumber, 
			@RequestParam String contactAddress,
			@RequestParam String email,
			@RequestParam int photoNumber,
			@RequestParam("file") MultipartFile file) throws IOException,PhotoNumberExistException {

		
		logger.info("SaveStudent controller reached");
				
		StudentDto savedStudentDto = new StudentDto();		
		StudentImageDto savedStudentImageDto=new StudentImageDto();
		Date dob = null;
		
		char c=bloodGroupName.charAt(bloodGroupName.length()-1);
		String str=String.valueOf(c);

		
		if(str.equalsIgnoreCase("-")){
			
		}
		else {
			bloodGroupName=bloodGroupName.trim()+"+";
		}			
		
				
		savedStudentDto.setStudentName(studentName);
		savedStudentDto.setFatherName(fatherName);
		
		savedStudentDto.setMotherName(motherName);
		savedStudentDto.setGender(gender);
		savedStudentDto.setClassId(classId);
		savedStudentDto.setClassName(className);
		savedStudentDto.setBloodId(bloodId);
		savedStudentDto.setBloodGroupName(bloodGroupName);
		savedStudentDto.setFatherMobileNumber(fatherMobileNumber);
		savedStudentDto.setMotherMobileNumber(motherMobileNumber);
		savedStudentDto.setAadharCardNumber(aadharCardNumber);
		savedStudentDto.setContactAddress(contactAddress);
		savedStudentDto.setPhotoNumber(photoNumber);		
		savedStudentDto.setEmail(email);		
		savedStudentDto.setReligionId(religionId);
		savedStudentDto.setReligionName(religionName);
					
		savedStudentImageDto.setImageFileName(file.getOriginalFilename());
		savedStudentImageDto.setImageType(file.getContentType());
		savedStudentImageDto.setImageData(ImageUtil.compressImage(file.getBytes()));
		
		savedStudentDto.setStudentImage(savedStudentImageDto);
				
		
		try {
			
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
			
			savedStudentDto.setDateOfBirth(dob);			
						 
			savedStudentDto = studentService.saveStudent(savedStudentDto);	
			
			return new ResponseEntity<StudentDto>(savedStudentDto, HttpStatus.CREATED);
			
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
				

	}	
	
	@PostMapping("/updateStudent")
	public ResponseEntity<StudentDto> updateStudent(
			@RequestParam Long studentId,
			@RequestParam String studentName, 
			@RequestParam String fatherName,
			@RequestParam String motherName,
			@RequestParam String gender, 
			@RequestParam String dateOfBirth,
			@RequestParam Long classId,
			@RequestParam String className,
			@RequestParam Long bloodId,
			@RequestParam String bloodGroupName,
			@RequestParam Long religionId,
			@RequestParam String religionName,
			@RequestParam String fatherMobileNumber, 
			@RequestParam String motherMobileNumber, 
			@RequestParam String aadharCardNumber, 
			@RequestParam String contactAddress,
			@RequestParam String email,
			@RequestParam int photoNumber,
			@RequestParam("file") MultipartFile file) throws IOException,PhotoNumberExistException {

		logger.info("UpdateStudent controller reached");
		StudentDto savedStudentDto = new StudentDto();
		StudentImageDto savedStudentImageDto=new StudentImageDto();
		Date dob = null;	
		
		char c=bloodGroupName.charAt(bloodGroupName.length()-1);
		String str=String.valueOf(c);

		
		if(str.equalsIgnoreCase("-")){
			
		}
		else {
			bloodGroupName=bloodGroupName.trim()+"+";
		}			
				
		savedStudentDto.setStudentId(studentId);
		savedStudentDto.setStudentName(studentName);
		savedStudentDto.setFatherName(fatherName);
		savedStudentDto.setMotherName(motherName);
		savedStudentDto.setGender(gender);
		savedStudentDto.setClassId(classId);
		savedStudentDto.setClassName(className);
		savedStudentDto.setReligionId(religionId);
		savedStudentDto.setReligionName(religionName);
		savedStudentDto.setBloodId(bloodId);
		savedStudentDto.setBloodGroupName(bloodGroupName);
		savedStudentDto.setFatherMobileNumber(fatherMobileNumber);
		savedStudentDto.setMotherMobileNumber(motherMobileNumber);
		savedStudentDto.setAadharCardNumber(aadharCardNumber);
		savedStudentDto.setContactAddress(contactAddress);
		savedStudentDto.setPhotoNumber(photoNumber);		
		savedStudentDto.setEmail(email);
		
		savedStudentImageDto.setImageFileName(file.getOriginalFilename());
		savedStudentImageDto.setImageType(file.getContentType());
		savedStudentImageDto.setImageData(ImageUtil.compressImage(file.getBytes()));
		
		savedStudentDto.setStudentImage(savedStudentImageDto);
		try {
			
			dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
			
			savedStudentDto.setDateOfBirth(dob);			
			 
			savedStudentDto = studentService.updateStudent(savedStudentDto);	
					

			return new ResponseEntity<StudentDto>(savedStudentDto, HttpStatus.CREATED);
			
		} catch (ParseException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
	}
	
	
	@GetMapping("/getStudentList")
	public ResponseEntity<List<StudentDto>> getStudentList() {
		try {
			logger.info("StudentList  controller reached");			
				List<StudentDto> studentDtoList=studentService.getStudentList();
							
				for(StudentDto studentDto:studentDtoList) {									
					
					studentDto.getStudentImage().setImageData(ImageUtil.decompressImage(studentDto.getStudentImage().getImageData()));
									
				}
							
				
				if(studentDtoList.size()==0) {
					return new ResponseEntity<List<StudentDto>>(studentDtoList, HttpStatus.NO_CONTENT);
				}
						
				
				
			return new ResponseEntity<List<StudentDto>>(studentDtoList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getStudentById/{studentId}") 
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long studentId){
	   
		    logger.info("StudentById controller reached");			
	    	StudentDto studenDto=studentService.getStudentById(studentId);		
			return new ResponseEntity<StudentDto>(studenDto, HttpStatus.OK);		
	  

	}	
	

	@DeleteMapping("/deleteByStudentId/{studentId}")
	public ResponseEntity<String> deleteByStudentId(@PathVariable Long studentId)  {

		logger.info("DeleteStudentById controller reached");		 
		ResponseEntity<String> resp = null;
		studentService.deleteByStudentId(studentId);		
		resp = new ResponseEntity<String>("Student '" + studentId + "' deleted", HttpStatus.OK);		

		return resp;

	}

	@GetMapping("/getMaleStudentList")
	public ResponseEntity<List<StudentDto>> getMaleStudentList() {
		logger.info("GetMaleStudentList controller reached");
		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getMaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getFemaleStudentList")
	public ResponseEntity<List<StudentDto>> getFemaleStudentList() {
		logger.info("GetFemaleStudentList controller reached");
		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getFemaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getBirthBabiesList")
	public ResponseEntity<List<StudentDto>> getBirthBabiesList() {
		logger.info("GetBirthBabiesList controller reached");
		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getBirthBabiesList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
	
	
	
	

}