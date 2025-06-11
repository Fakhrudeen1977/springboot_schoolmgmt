package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	//String findByRoleName(String roleName);
	Role findByRoleName(String roleName);
}
