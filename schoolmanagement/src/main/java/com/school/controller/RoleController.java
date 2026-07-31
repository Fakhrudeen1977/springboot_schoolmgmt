package com.school.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.dto.RoleDto;
import com.school.service.RoleService;
@RestController
@RequestMapping("/role")
public class RoleController {

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;

	@PostMapping("/saveRole")
	public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
		logger.info("Save Role Method  Controller");
		RoleDto savedroleDto = new RoleDto();

		try {

			if (roleDto.getRoleId() == null) {
				savedroleDto = roleService.saveRole(roleDto);
			} else {
				savedroleDto = roleService.saveRole(roleDto);

			}
			return new ResponseEntity<RoleDto>(savedroleDto, HttpStatus.CREATED);

		}

		catch (Exception e) {
			return new ResponseEntity<RoleDto>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/getRoleList")
	public ResponseEntity<List<RoleDto>> getRoleList() {

		List<RoleDto> roleDtoList = roleService.getRoleList();
		return ResponseEntity.ok(roleDtoList);
	}

	@DeleteMapping("/deleteByRoleId/{roleId}")
	public ResponseEntity<String> deleteByRoleId(@PathVariable Long roleId) {
		
		ResponseEntity<String> resp = null;
		roleService.deleteByRoleId(roleId);
		resp = new ResponseEntity<String>("Role '" + roleId + "' deleted", HttpStatus.OK);

		return resp;

	}
}
