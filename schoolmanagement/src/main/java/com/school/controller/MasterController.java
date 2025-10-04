package com.school.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.BloodGroupDto;
import com.school.dto.ClassDetailsDto;
import com.school.dto.ReligionDto;
import com.school.dto.UserDto;
import com.school.entity.ClassDetails;
import com.school.entity.Role;
import com.school.entity.Student;
import com.school.service.MasterService;

@RestController
@RequestMapping("/master")
@CrossOrigin(origins = "http://localhost:4200")
public class MasterController {

	@Autowired
	private MasterService masterService;

	@Autowired
	PasswordEncoder encoder;
	
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	@PostMapping("/saveBloodGroup")
	public ResponseEntity<BloodGroupDto> saveBloodGroup(@RequestBody BloodGroupDto bloodGroupDto) {
		BloodGroupDto savedBloodGrpDto = new BloodGroupDto();

		try {

			if (bloodGroupDto.getBloodId() == null) {
				savedBloodGrpDto = masterService.saveBloodGroup(bloodGroupDto);
			} else {

				savedBloodGrpDto = masterService.saveBloodGroup(bloodGroupDto);

			}
			return new ResponseEntity<BloodGroupDto>(savedBloodGrpDto, HttpStatus.CREATED);

		}

		catch (Exception e) {
			return new ResponseEntity<BloodGroupDto>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/getBloodGroupList")
	public ResponseEntity<List<BloodGroupDto>> getBloodGroupList() {
	
		List<BloodGroupDto> bloodGroupDtoList = masterService.getBloodGroupList();
		return ResponseEntity.ok(bloodGroupDtoList);
	}

	@GetMapping("/getReligionList")
	public ResponseEntity<List<ReligionDto>> getReligionList() {
		
	
		List<ReligionDto> religionDtoList = masterService.getReligionList();
		System.out.println("Length of Religion List"+" "+religionDtoList.size());
		return ResponseEntity.ok(religionDtoList);
	}
	
	
	
	
	
	@PostMapping("/saveClassDetail")
	public ResponseEntity<ClassDetailsDto> saveClassDetail(@RequestBody ClassDetailsDto classDetailsDto) {
		ClassDetailsDto savedClassDetailsDto = new ClassDetailsDto();
		
		try {

			if (classDetailsDto.getClassId() == null) {
				savedClassDetailsDto = masterService.saveClassDetail(classDetailsDto);
			} else {
				savedClassDetailsDto = masterService.saveClassDetail(classDetailsDto);

			}
			return new ResponseEntity<ClassDetailsDto>(savedClassDetailsDto, HttpStatus.CREATED);

		}

		catch (Exception e) {
			return new ResponseEntity<ClassDetailsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getClassDetailList")
	public ResponseEntity<Page<ClassDetails>> getClassDetailList(@RequestParam String pageNo , @RequestParam String perPage) {
		
			
		 Page<ClassDetails> list =masterService.getClassDetailList(Integer.parseInt(pageNo),Integer.parseInt(perPage));

		 return ResponseEntity.ok(list);
	
	
	}
	
	
	

	@DeleteMapping("/deleteBloodGroupId/{bloodGroupId}")
	public ResponseEntity<String> deleteBloodGroupId(@PathVariable Long bloodGroupId) {
		
			ResponseEntity<String> resp = null;
			 try {
				 masterService.deleteBloodGroupId(bloodGroupId);
				 resp = new ResponseEntity<String>("Student '" + bloodGroupId + "' deleted", HttpStatus.OK);
			 }
			 catch(Exception e) {
				 
			 }
						
			 return resp;

	}

	@GetMapping("/getStudentListByClassId/{classId}")
	public ResponseEntity<List<Student>> getStudentListByClassName(@PathVariable Long classId) {
		
		List<Student> studentList = masterService.getStudentListByClassId(classId);
		return ResponseEntity.ok(studentList);

	}

	@GetMapping("/getRoleList")
	public ResponseEntity<List<Role>> getRoleList() {
		List<Role> roleList = masterService.getRoleList();
		return ResponseEntity.ok(roleList);

	}

	@GetMapping("/getUserList")
	public ResponseEntity<List<UserDto>> getUserList() {
		List<UserDto> userDtoList = masterService.getUserList();
		return ResponseEntity.ok(userDtoList);

	}

	@DeleteMapping("/deleteByUserId/{userId}")
	public ResponseEntity<String> deleteByUserId(@PathVariable Long userId) {
		
		ResponseEntity<String> resp = null;
		try {
			int result = masterService.deleteByUserId(userId);
			System.out.println("Result" + " " + result);
			if (result == 1)
				resp = new ResponseEntity<String>("User Id '" + userId + "' deleted", HttpStatus.OK);

		} catch (Exception e) {

		}
		return resp;

	}

	
}
