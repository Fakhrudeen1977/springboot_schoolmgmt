package com.school.service;

import java.util.List;

import com.school.dto.BloodGroupDto;
import com.school.dto.ClassDetailsDto;
import com.school.dto.UserDto;
import com.school.entity.ClassDetails;
import com.school.entity.Role;
import com.school.entity.Student;
import com.school.exception.BloodGroupIdNotFoundException;
import com.school.exception.StudentNotFoundException;


public interface MasterService {
	public List<BloodGroupDto> getBloodGroupList();
	public List<ClassDetails> getClassDetailList();
	public List<Role> getRoleList();
	public BloodGroupDto saveBloodGroup(BloodGroupDto bloodGrpDto);
	public ClassDetailsDto saveClassDetail(ClassDetailsDto classDetailsDto);
	public void deleteBloodGroupId(Long bloodGroupId) throws BloodGroupIdNotFoundException ;
	
	public List<Student> getStudentListByClassId(Long classId);
	public List<UserDto> getUserList();
	
	public int deleteByUserId(Long userId) ;
	
}
