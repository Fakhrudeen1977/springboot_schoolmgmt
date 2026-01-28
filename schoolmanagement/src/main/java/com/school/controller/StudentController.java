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

		
		logger.info("SaveStudent End point called");
		System.out.println("Save Controller called"+" "+file.getContentType()+" "+file.getOriginalFilename());
		
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
		
		logger.info("Saved Student called"+" "+dateOfBirth);
		
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

		System.out.println("Update Student called"+" "+dateOfBirth);
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
			    System.out.println("Student List Viewed");					
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
	   
	    	StudentDto studenDto=studentService.getStudentById(studentId);		
			return new ResponseEntity<StudentDto>(studenDto, HttpStatus.OK);		
	  

	}	
		
	
	/*@GetMapping("/test")
	public String test() {
		throw new StudentIdNotFoundException("Student");
	}*/

	@DeleteMapping("/deleteByStudentId/{studentId}")
	public ResponseEntity<String> deleteByStudentId(@PathVariable Long studentId)  {

		ResponseEntity<String> resp = null;
		studentService.deleteByStudentId(studentId);		
		resp = new ResponseEntity<String>("Student '" + studentId + "' deleted", HttpStatus.OK);		

		return resp;

	}

	@GetMapping("/getMaleStudentList")
	public ResponseEntity<List<StudentDto>> getMaleStudentList() {

		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getMaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getFemaleStudentList")
	public ResponseEntity<List<StudentDto>> getFemaleStudentList() {

		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getFemaleStudentList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getBirthBabiesList")
	public ResponseEntity<List<StudentDto>> getBirthBabiesList() {

		try {
			
			return new ResponseEntity<List<StudentDto>>(studentService.getBirthBabiesList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}	
	
	/* @PostMapping("/uploadFile")
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
	 }*/
	
	
	
	
	/*for(StudentDto studentDto: studentDtoList ) {
	
	studentViewDto=new StudentViewDto();
	studentViewDto.setStudentId(studentDto.getStudentId());
	studentViewDto.setStudentName(studentDto.getStudentName());
	studentViewDto.setFatherName(studentDto.getFatherName());
	studentViewDto.setMotherName(studentDto.getMotherName());
	studentViewDto.setGender(studentDto.getGender());
	studentViewDto.setDateOfBirth(studentDto.getDateOfBirth());
	studentViewDto.setClassId(studentDto.getClassId());
	studentViewDto.setClassName(studentDto.getClassName());
	studentViewDto.setBloodId(studentDto.getBloodId());
	studentViewDto.setBloodGroupName(studentDto.getBloodGroupName().trim());
	studentViewDto.setFatherMobileNumber(studentDto.getFatherMobileNumber());
	studentViewDto.setMotherMobileNumber(studentDto.getMotherMobileNumber());
	studentViewDto.setContactAddress(studentDto.getContactAddress());
	studentViewDto.setAadharCardNumber(studentDto.getAadharCardNumber());
	studentViewDto.setPhotoNumber(studentDto.getPhotoNumber());		
	studentViewDto.setEmail(studentDto.getEmail());
	studentViewDto.setReligionId(studentDto.getReligionId());
	studentViewDto.setReligionName(studentDto.getReligionName());
	
	
	studentViewDtoList.add(studentViewDto);
	
}*/
	
	
	

}