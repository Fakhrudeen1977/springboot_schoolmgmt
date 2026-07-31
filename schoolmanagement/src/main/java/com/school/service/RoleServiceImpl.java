package com.school.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.RoleDto;
import com.school.entity.Role;
import com.school.exception.RoleIdNotFoundException;
import com.school.mapper.OrikaBeanMapper;
import com.school.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	
	@Override
	@Transactional
	public RoleDto saveRole(RoleDto roleDto) {
		logger.info("SaveRole Method");
				
		Role role= mapper.map(roleDto, Role.class);
		role= roleRepository.saveAndFlush(role);
				
		RoleDto roleDtoResponse  = mapper.map(role, RoleDto.class);
		return roleDtoResponse;
		
		}
	
	

	@Override
	public List<RoleDto> getRoleList() {
		logger.info("Get RoleList Method");
		List<Role> roleList= roleRepository.findAll();
		List<RoleDto> roleDtoList=mapper.mapAsList(roleList, RoleDto.class);
		return roleDtoList;
	}	
	
	@Override
	@Transactional
	public void deleteByRoleId(Long roleId) throws RoleIdNotFoundException  {		 
		logger.info("DeleteByRoleId Method");	 
		 if (!roleRepository.existsById(roleId)) {
			 
		        throw new RoleIdNotFoundException("Role Id " + roleId + " Not Found");
		    }
		 
		    roleRepository.deleteById(roleId);	 
			 

}	
	
	
	
	
	
	
	

}
