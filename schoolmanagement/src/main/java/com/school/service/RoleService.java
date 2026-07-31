package com.school.service;
import java.util.List;
import com.school.dto.RoleDto;
import com.school.exception.RoleIdNotFoundException;

public interface RoleService {
	public List<RoleDto> getRoleList();
	public RoleDto saveRole(RoleDto roleDto);
	public void deleteByRoleId(Long roleId) throws RoleIdNotFoundException ;
		
	
}
