package com.school.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.school.dto.BloodGroupDto;
import com.school.dto.ClassDetailsDto;
import com.school.dto.ReligionDto;
import com.school.dto.UserDto;
import com.school.entity.ClassDetails;
import com.school.entity.Student;
import com.school.exception.BloodGroupIdNotFoundException;

public interface MasterService {
	public BloodGroupDto saveBloodGroup(BloodGroupDto bloodGrpDto);
	public List<BloodGroupDto> getBloodGroupList();	
	public void deleteByBloodGroupId(Long bloodGroupId) throws BloodGroupIdNotFoundException ;
	
	
	public Page<ClassDetails> getClassDetailList(int currentPage,int pageSize);
		
	public List<ReligionDto> getReligionList();
	
	public ClassDetailsDto saveClassDetail(ClassDetailsDto classDetailsDto);
	
	
	public List<Student> getStudentListByClassId(Long classId);
	public List<UserDto> getUserList();
	
	public int deleteByUserId(Long userId) ;
	
}
