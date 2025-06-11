package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.LeaveReason;

public interface LeaveReasonRepository extends JpaRepository<LeaveReason, Long> {
	//@Modifying
	//@Transactional
	
	//@Query("delete from LeaveReason l  where l.leave_ReasonId=:leaveReasonId")
	//public void deleteByLeaveReasonId(@Param("leaveReasonId") Long leaveReasonId);
	

}
