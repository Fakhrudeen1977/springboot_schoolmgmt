package com.school.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.LeaveReasonDto;
import com.school.dto.LeavingReasonDto;
import com.school.entity.LeaveReason;
import com.school.entity.LeavingReason;
import com.school.mapper.OrikaBeanMapper;
import com.school.repository.LeaveReasonRepository;
import com.school.repository.LeavingReasonRepository;

@Service
public class LeaveReasonServiceImpl implements LeaveReasonService {

	
	@Autowired
	private LeaveReasonRepository leaveReasonRepository;
	
	@Autowired
	private LeavingReasonRepository leavingReasonRepository;
	
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	@Override
	public LeaveReasonDto saveLeaveReason(LeaveReasonDto leaveReasonDto) {
		// TODO Auto-generated method stub
		System.out.println("Leaving Date"+" "+leaveReasonDto.getLeavingDate());			
		LeaveReason leaveReason= mapper.map(leaveReasonDto, LeaveReason.class);
		leaveReason= leaveReasonRepository.saveAndFlush(leaveReason);
				
		LeaveReasonDto LeaveReasnDto  = mapper.map(leaveReason, LeaveReasonDto.class);
		return LeaveReasnDto;
		
		
	}

	@Override
	public List<LeaveReasonDto> getLeaveReasonList() {
		
		List<LeaveReason> leaveReasonList= leaveReasonRepository.findAll();
		List<LeaveReasonDto> leaveReasonDtoList=mapper.mapAsList(leaveReasonList, LeaveReasonDto.class);
		return leaveReasonDtoList;
		
	}

	@Override
	@Transactional
	public void deleteByLeaveId(Long leaveId)   {		 
		 		
		 try {
			 if(this.checkLeaveReasonIdExistOrNot(leaveId)) 
				 leaveReasonRepository.deleteById(leaveId);
				 		
			
			/* else 
				 throw new BloodGroupIdNotFoundException("BloodGroup Id"+" "+bloodGroupId+" "+"Not Found");
			 }*/
				
		 }
		
		catch(Exception e) {
			System.out.println("Exception Occured");
		}
		 		
		 
		 
	

}	
	
	
	public boolean checkLeaveReasonIdExistOrNot(Long leaveReasonId  ) {
		boolean isFlag=false;
		Optional<LeaveReason> option = leaveReasonRepository.findById(leaveReasonId);

		if (option.isPresent()) {
			return isFlag=true;
		}

		return isFlag;
	}

	@Override
	public List<LeavingReasonDto> getLeavingReasonList() {
		List<LeavingReason> leavingReasonList= leavingReasonRepository.findAll();
		List<LeavingReasonDto> leavingReasonDtoList=mapper.mapAsList(leavingReasonList, LeavingReasonDto.class);
		return leavingReasonDtoList;
		
	}




}
