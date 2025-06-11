package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.school.entity.BloodGroup;

@Repository
public interface BloodRepository extends JpaRepository<BloodGroup, Long> {
	
	@Modifying
	
	@Query("update BloodGroup b set b.activeStatus=false where b.bloodId=:bloodId")
	public int deleteBloodGroupId(@Param("bloodId") Long bloodId);
	
	@Query("select b from BloodGroup b where b.activeStatus=true")
	public List<BloodGroup> findAllActiveOnly();

}
