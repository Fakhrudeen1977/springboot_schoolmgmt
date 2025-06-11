package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.entity.User;
import com.school.queryconstant.Querys;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
 
	public Optional<User> findByUserName(String userName);
	public boolean existsByEmail(String email);
	public boolean existsByUserName(String userName);	
	public Optional<User> findByUserId(Long userId);
	
	
	@Modifying  
	@Transactional
	@Query(nativeQuery = true,value = Querys.DELETE_ROLES_BYUSERID)   
	public void deleteRolesByUserId(@Param("userId") Long userId);
	
	
	
	@Modifying  
	@Transactional
	@Query(nativeQuery = true,value = Querys.DELETE_BYUSERID)   
	public void deleteByUserId(@Param("userId") Long userId);
	
	
	
	
 	
}
