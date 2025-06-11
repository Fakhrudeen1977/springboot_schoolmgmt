package com.school.service;

import java.util.List;

import com.school.dto.LeaveReasonDto;
import com.school.dto.LeavingReasonDto;

public interface LeaveReasonService {
	public LeaveReasonDto saveLeaveReason(LeaveReasonDto leaveReasonDto);
	public List<LeaveReasonDto> getLeaveReasonList();
	public List<LeavingReasonDto> getLeavingReasonList();
	public void deleteByLeaveId(Long leaveId );
	
	
}
