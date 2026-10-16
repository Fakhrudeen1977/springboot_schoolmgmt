package com.school.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.school.entity.Student;
import com.school.service.MasterService;

@RestController
@RequestMapping("/master")
public class MasterController {

	@Autowired
	private MasterService masterService;

	@Autowired
	PasswordEncoder encoder;

	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	@PostMapping("/saveBloodGroup")
	public ResponseEntity<BloodGroupDto> saveBloodGroup(@RequestBody BloodGroupDto bloodGroupDto) {
		logger.info("Save BloodGroup -Controller");
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
		logger.info("Get BloodGroupList -Controller");

		List<BloodGroupDto> bloodGroupDtoList = masterService.getBloodGroupList();
		return ResponseEntity.ok(bloodGroupDtoList);
	}

	@GetMapping("/getReligionList")
	public ResponseEntity<List<ReligionDto>> getReligionList() {
		logger.info("Get ReligionList -Controller");

		List<ReligionDto> religionDtoList = masterService.getReligionList();

		return ResponseEntity.ok(religionDtoList);
	}

	@PostMapping("/saveClassDetail")
	public ResponseEntity<ClassDetailsDto> saveClassDetail(@RequestBody ClassDetailsDto classDetailsDto) {
		logger.info("SaveClassDetail -Controller");
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

	@GetMapping("/getClassDetailListPagination")
	public ResponseEntity<Page<ClassDetails>> getClassDetailListPagination(
			@RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "5") int pageSize) {
		logger.info("Get ClassDetailList -Controller");
		Page<ClassDetails> list = masterService.getClassDetailListPagination(pageIndex, pageSize);

		return ResponseEntity.ok(list);

	}

	@GetMapping("/getClassDetailList")
	public ResponseEntity<List<ClassDetailsDto>> getClassDetailList() {
		logger.info("Get ClassDetailList -Controller");
		List<ClassDetailsDto> list = masterService.getClassDetailList();
		return ResponseEntity.ok(list);

	}
	

	@DeleteMapping("/deleteByBloodGroupId/{bloodGroupId}")
	public ResponseEntity<String> deleteByBloodGroupId(@PathVariable Long bloodGroupId) {
		logger.info("Get DeleteByBloodGroupId -Controller");
		ResponseEntity<String> resp = null;
		masterService.deleteByBloodGroupId(bloodGroupId);
		resp = new ResponseEntity<String>("Blood Group with ID  '" + bloodGroupId + "' deleted", HttpStatus.OK);

		return resp;

	}


	@DeleteMapping("/deleteByClassId/{classId}")
	public ResponseEntity<String> deleteByClassId(@PathVariable Long classId) {
		logger.info("Get DeleteByClassId -Controller");
		ResponseEntity<String> resp = null;
		masterService.deleteByClassId(classId);
		resp = new ResponseEntity<String>("Class with ID  '" + classId + "' deleted", HttpStatus.OK);

		return resp;

	}

	@GetMapping("/getStudentListByClassId/{classId}")
	public ResponseEntity<List<Student>> getStudentListByClassId(@PathVariable Long classId) {
		logger.info("Get StudentListByClassName -Method");
		List<Student> studentList = masterService.getStudentListByClassId(classId);
		return ResponseEntity.ok(studentList);

	}

	@GetMapping("/getUserList")
	public ResponseEntity<List<UserDto>> getUserList() {
		logger.info("Get UserList -Method");
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
