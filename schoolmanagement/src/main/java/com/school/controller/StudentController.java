package com.school.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.school.dto.StudentViewDto;
import com.school.entity.Student;
import com.school.exception.PhotoNumberExistException;
import com.school.exception.StudentNotFoundException;
import com.school.service.ExcelService;
import com.school.service.StudentService;
import com.school.util.ExcelUtility;
import com.school.util.ImageUtil;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")

public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	ExcelService excelService;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class); 
	
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentDto> saveStudent(@RequestParam String studentName, @RequestParam String fatherName,
			@RequestParam String gender, @RequestParam String dateOfBirth, @RequestParam Long classId,
			@RequestParam String className,
			@RequestParam Long bloodId,
			@RequestParam String bloodGroupName,
			@RequestParam String mobileNumber, @RequestParam String contactAddress,
			@RequestParam int photoNumber, @RequestParam("file") MultipartFile file) throws IOException,PhotoNumberExistException {

		
		StudentDto savedStudentDto = new StudentDto();
		Date dob = null;
		System.out.println("Saved Student called"+" "+dateOfBirth);
		char c=bloodGroupName.charAt(bloodGroupName.length()-1);
		String str=String.valueOf(c);
		
		
		if(str.equalsIgnoreCase("-")){
			
		}
		else {
			bloodGroupName=bloodGroupName.trim()+"+";
		}			
		
		savedStudentDto.setStudentName(studentName);
		savedStudentDto.setFatherName(fatherName);
		savedStudentDto.setGender(gender);
		savedStudentDto.setClassId(classId);
		savedStudentDto.setClassName(className);
		savedStudentDto.setBloodId(bloodId);
		savedStudentDto.setBloodGroupName(bloodGroupName);
		savedStudentDto.setMobileNumber(mobileNumber);
		savedStudentDto.setContactAddress(contactAddress);
		savedStudentDto.setPhotoNumber(photoNumber);		
		
		savedStudentDto.setImageFileName(file.getOriginalFilename());
		savedStudentDto.setImageType(file.getContentType());
		savedStudentDto.setImageData(ImageUtil.compressImage(file.getBytes()));
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
	public ResponseEntity<StudentDto> updateStudent(@RequestParam Long studentId,@RequestParam String studentName, @RequestParam String fatherName,
			@RequestParam String gender, @RequestParam String dateOfBirth,@RequestParam Long classId,
			@RequestParam String className,
			@RequestParam Long bloodId,
			@RequestParam String bloodGroupName,
			@RequestParam String mobileNumber, @RequestParam String contactAddress,
			@RequestParam int photoNumber, @RequestParam("file") MultipartFile file) throws IOException,PhotoNumberExistException {

		System.out.println("Update Student called"+" "+dateOfBirth);
		StudentDto savedStudentDto = new StudentDto();
		Date dob = null;		
		
		char c=bloodGroupName.charAt(bloodGroupName.length()-1);
		System.out.println("Character"+" +c");
		String str=String.valueOf(c);
		System.out.println("String "+" "+str);
		
		
		if(str.equalsIgnoreCase("-")){
			
		}
		else {
			bloodGroupName=bloodGroupName.trim()+"+";
		}			
		
		savedStudentDto.setStudentId(studentId);
		savedStudentDto.setStudentName(studentName);
		savedStudentDto.setFatherName(fatherName);
		savedStudentDto.setGender(gender);
		savedStudentDto.setClassId(classId);
		savedStudentDto.setClassName(className);
		savedStudentDto.setBloodId(bloodId);
		savedStudentDto.setBloodGroupName(bloodGroupName);
		savedStudentDto.setMobileNumber(mobileNumber);
		savedStudentDto.setContactAddress(contactAddress);
		savedStudentDto.setPhotoNumber(photoNumber);		
		
		savedStudentDto.setImageFileName(file.getOriginalFilename());
		savedStudentDto.setImageType(file.getContentType());
		savedStudentDto.setImageData(ImageUtil.compressImage(file.getBytes()));
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
	public ResponseEntity<List<StudentViewDto>> getStudentList() {

		try {
			   
				StudentViewDto studentViewDto=null;
				List<StudentDto> studentDtoList=studentService.getStudentList();
				
				List<StudentViewDto> studentViewDtoList=new ArrayList<StudentViewDto>();
				System.out.println("Student Count"+" "+studentDtoList.size());
				
				
				for(StudentDto studentDto: studentDtoList ) {
					
					studentViewDto=new StudentViewDto();
					studentViewDto.setStudentId(studentDto.getStudentId());
					studentViewDto.setStudentName(studentDto.getStudentName());
					studentViewDto.setFatherName(studentDto.getFatherName());
					studentViewDto.setGender(studentDto.getGender());
					studentViewDto.setDateOfBirth(studentDto.getDateOfBirth());
					studentViewDto.setClassId(studentDto.getClassId());
					studentViewDto.setClassName(studentDto.getClassName());
					studentViewDto.setBloodId(studentDto.getBloodId());
					studentViewDto.setBloodGroupName(studentDto.getBloodGroupName().trim());
					studentViewDto.setMobileNumber(studentDto.getMobileNumber());
					studentViewDto.setContactAddress(studentDto.getContactAddress());
					studentViewDto.setPhotoNumber(studentDto.getPhotoNumber());		
					
					studentViewDto.setImageFileName(studentDto.getImageFileName());
					studentViewDto.setImageType(studentDto.getImageType());
					studentViewDto.setImageData(ImageUtil.decompressImage(studentDto.getImageData()));
					
					studentViewDtoList.add(studentViewDto);
					
				}
				
			return new ResponseEntity<List<StudentViewDto>>(studentViewDtoList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getStudentById/{studentId}")
	public ResponseEntity<StudentViewDto> getStudentById(@PathVariable Long studentId) {

		try {
			
			Optional<StudentDto> studentDto=studentService.getStudentById(studentId);
			
			StudentViewDto studentViewDto=new StudentViewDto();
			studentViewDto.setStudentId(studentDto.get().getStudentId());
			studentViewDto.setStudentName(studentDto.get().getStudentName());
			studentViewDto.setFatherName(studentDto.get().getFatherName());
			studentViewDto.setGender(studentDto.get().getGender());
			studentViewDto.setDateOfBirth(studentDto.get().getDateOfBirth());
			studentViewDto.setClassId(studentDto.get().getClassId());
			studentViewDto.setClassName(studentDto.get().getClassName());
			studentViewDto.setBloodId(studentDto.get().getBloodId());
			studentViewDto.setBloodGroupName(studentDto.get().getBloodGroupName().trim());
			studentViewDto.setMobileNumber(studentDto.get().getMobileNumber());
			studentViewDto.setContactAddress(studentDto.get().getContactAddress());
			studentViewDto.setPhotoNumber(studentDto.get().getPhotoNumber());		
			
			studentViewDto.setImageFileName(studentDto.get().getImageFileName());
			studentViewDto.setImageType(studentDto.get().getImageType());
			studentViewDto.setImageData(ImageUtil.decompressImage(studentDto.get().getImageData()));
					
			
			//return new ResponseEntity<StudentDto>(studentService.getStudentById(studentId), HttpStatus.OK);
			return new ResponseEntity<StudentViewDto>(studentViewDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
	
	

	@DeleteMapping("/deleteByStudentId/{studentId}")
	public ResponseEntity<String> deleteByStudentId(@PathVariable Long studentId) throws StudentNotFoundException {

		ResponseEntity<String> resp = null;
		studentService.deleteByStudentId(studentId);		
		resp = new ResponseEntity<String>("Student '" + studentId + "' deleted", HttpStatus.OK);		

		return resp;

	}

	@GetMapping("/getMaleStudentList")
	public ResponseEntity<List<Student>> getMaleStudentList() {

		try {
			
			return new ResponseEntity<List<Student>>(studentService.getMaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getFemaleStudentList")
	public ResponseEntity<List<Student>> getFemaleStudentList() {

		try {
			
			return new ResponseEntity<List<Student>>(studentService.getFemaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getBirthBabiesList")
	public ResponseEntity<List<Student>> getBirthBabiesList() {

		try {
			
			return new ResponseEntity<List<Student>>(studentService.getBirthBabiesList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
	
	 @PostMapping("/uploadFile")
	  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	   if (ExcelUtility.hasExcelFormat(file)) {
	      try {
	        excelService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	 }
	

}