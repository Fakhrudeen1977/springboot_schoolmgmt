package com.school.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.controller.MasterController;
import com.school.dto.BloodGroupDto;
import com.school.dto.ClassDetailsDto;
import com.school.dto.UserDto;
import com.school.entity.BloodGroup;
import com.school.entity.ClassDetails;
import com.school.entity.Role;
import com.school.entity.Student;
import com.school.entity.User;
import com.school.exception.BloodGroupIdNotFoundException;
import com.school.mapper.OrikaBeanMapper;
import com.school.repository.BloodRepository;
import com.school.repository.ClassRepository;
import com.school.repository.RoleRepository;
import com.school.repository.StudentRepository;
import com.school.repository.UserRepository;

@Service
public class MasterServiceImpl implements MasterService {
	
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BloodRepository bloodGrpRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrikaBeanMapper mapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);
	
	@Override
	public List<BloodGroupDto> getBloodGroupList() {		
		
		List<BloodGroup> bloodGroupList= bloodGrpRepository.findAllActiveOnly();
		List<BloodGroupDto> bloodGroupDtoList=mapper.mapAsList(bloodGroupList, BloodGroupDto.class);
		return bloodGroupDtoList;
		
	}
	
	

	@Override
	public List<ClassDetails> getClassDetailList() {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}

	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	@Transactional
	public BloodGroupDto saveBloodGroup(BloodGroupDto bloodGroupDto) {
			
		
		bloodGroupDto.setActiveStatus(true); 
		BloodGroup bloodGroup= mapper.map(bloodGroupDto, BloodGroup.class);
		bloodGroup= bloodGrpRepository.saveAndFlush(bloodGroup);
				
		BloodGroupDto bloodGroupDto1  = mapper.map(bloodGroup, BloodGroupDto.class);
		return bloodGroupDto1;
		
		}

	@Override
	@Transactional
	public ClassDetailsDto saveClassDetail(ClassDetailsDto classDetailsDto) {
		ClassDetails classDetails= mapper.map(classDetailsDto, ClassDetails.class);
		classDetails= classRepository.saveAndFlush(classDetails);
				
		ClassDetailsDto classDetailsDto1  = mapper.map(classDetails, ClassDetailsDto.class);
		return classDetailsDto1;
	}



	@Override
	@Transactional
	public void deleteBloodGroupId(Long bloodGroupId) throws BloodGroupIdNotFoundException  {		 
		
		 try {
			 if(this.checkBloodGroupIdExistOrNot(bloodGroupId)) {				 
				 bloodGrpRepository.deleteBloodGroupId(bloodGroupId);				 		
				
			 }
			 else 
				 throw new BloodGroupIdNotFoundException("BloodGroup Id"+" "+bloodGroupId+" "+"Not Found");			 
				
		 }
		
		catch(Exception e) {
			System.out.println("Exception Occured");
		} 
	

}	
	
	
	public boolean checkBloodGroupIdExistOrNot(Long bloodGroupId  ) {
		boolean isFlag=false;
		Optional<BloodGroup> option = bloodGrpRepository.findById(bloodGroupId);

		if (option.isPresent()) {
			return isFlag=true;
		}

		return isFlag;
	}



	@Override
	public List<Student> getStudentListByClassId(Long classId) {
		
		return studentRepository.getStudentListByClassId(classId);
	}	
	
	@Override
	public List<UserDto> getUserList() {
		List<User> userList= userRepository.findAll();
		List<UserDto> userDtoList  = mapper.mapAsList(userList, UserDto.class);		
		return userDtoList;
		
	}



	@Transactional 
	@Override
	public int deleteByUserId(Long userId) {
		System.out.println("Reached Here"+"  "+userId);
		userRepository.deleteRolesByUserId(userId);
		userRepository.deleteByUserId(userId);		
		return 1;
	}
	

}
