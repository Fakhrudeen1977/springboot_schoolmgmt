package com.school.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.school.dto.BloodGroupDto;
import com.school.dto.ClassDetailsDto;
import com.school.dto.ReligionDto;
import com.school.dto.UserDto;
import com.school.entity.ClassDetails;
import com.school.entity.Role;
import com.school.entity.Student;
import com.school.exception.BloodGroupIdNotFoundException;


public interface MasterService {
	public List<BloodGroupDto> getBloodGroupList();
	public Page<ClassDetails> getClassDetailList(int currentPage,int pageSize);
	public List<Role> getRoleList();
	
	public List<ReligionDto> getReligionList();
	public BloodGroupDto saveBloodGroup(BloodGroupDto bloodGrpDto);
	public ClassDetailsDto saveClassDetail(ClassDetailsDto classDetailsDto);
	public void deleteBloodGroupId(Long bloodGroupId) throws BloodGroupIdNotFoundException ;
	
	public List<Student> getStudentListByClassId(Long classId);
	public List<UserDto> getUserList();
	
	public int deleteByUserId(Long userId) ;
	
}
