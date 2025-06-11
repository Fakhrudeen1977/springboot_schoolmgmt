package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.LeaveReasonDto;
import com.school.dto.LeavingReasonDto;
import com.school.service.LeaveReasonService;
@RestController
@RequestMapping("/leavereason")
@CrossOrigin(origins="http://localhost:4200")  
public class LeavingReasonController {
	
	
	
	@Autowired
	private LeaveReasonService leaveReasonService;

	@PostMapping("/saveLeaveReason")
	public ResponseEntity<LeaveReasonDto> saveLeaveReason(@RequestBody LeaveReasonDto leaveReasonDto){
		LeaveReasonDto leaveReasnDto=new LeaveReasonDto();
			System.out.println("Leaving Date"+" "+leaveReasonDto.getLeavingDate());
		try {
						
			if(leaveReasonDto.getLeaveId()==null) {				
				leaveReasnDto=leaveReasonService.saveLeaveReason(leaveReasonDto);			
			}
			else {
				
				leaveReasnDto=leaveReasonService.saveLeaveReason(leaveReasonDto);		
			}
			return new ResponseEntity<LeaveReasonDto>(leaveReasnDto,HttpStatus.CREATED);			
			
		}
	
		catch(Exception e) {
			return new ResponseEntity<LeaveReasonDto>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
				
	}		
	
	
	@GetMapping("/getLeaveReasonList")
	public ResponseEntity <List<LeaveReasonDto>> getLeaveReasonList(){
		
		List<LeaveReasonDto> leaveReasonDtoList  = leaveReasonService.getLeaveReasonList();
		return ResponseEntity.ok(leaveReasonDtoList);		
		
	}	
	
	@GetMapping("/getLeavingReasonList")
	public ResponseEntity <List<LeavingReasonDto>> getLeavingReasonList(){
		
		List<LeavingReasonDto> leavingReasonDtoList  = leaveReasonService.getLeavingReasonList();
		return ResponseEntity.ok(leavingReasonDtoList);		
		
	}	
	
	
	@DeleteMapping("/deleteByLeaveId/{leaveId}")
	public ResponseEntity<String> deleteByLeaveId(@PathVariable Long leaveId)   {
	
		ResponseEntity<String> resp= null;
		try 
		{
			leaveReasonService.deleteByLeaveId(leaveId);
			
			resp= new ResponseEntity<String> ("LeaveReason Id "+leaveId+"' deleted",HttpStatus.OK);
					
		} catch (Exception e) {
			
		}	
		return resp;
		
	}	
	

}
