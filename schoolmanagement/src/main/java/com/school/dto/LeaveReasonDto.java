package com.school.dto;

import java.io.Serializable;
import java.util.Date;

public class LeaveReasonDto implements Serializable {
	
	   
	

	    private static final long serialVersionUID = 1L;
		public LeaveReasonDto() {
			
		}
			
		private Long leaveId;
		private String leave_statusId;
		private String leave_statusValue;
		private Long year;
		private Date leavingDate;
		private Long classId;
		private String className;
		private Long studentId;
		private String studentName;		
		private Long leavingReasonId;
		private String leavingReasonValue;
		private Long age;
		
		
		public Long getLeaveId() {
			return leaveId;
		}
		public void setLeaveId(Long leaveId) {
			this.leaveId = leaveId;
		}
		public String getLeave_statusId() {
			return leave_statusId;
		}
		public void setLeave_statusId(String leave_statusId) {
			this.leave_statusId = leave_statusId;
		}
		public String getLeave_statusValue() {
			return leave_statusValue;
		}
		public void setLeave_statusValue(String leave_statusValue) {
			this.leave_statusValue = leave_statusValue;
		}
		public Long getYear() {
			return year;
		}
		public void setYear(Long year) {
			this.year = year;
		}
		public Date getLeavingDate() {
			return leavingDate;
		}
		public void setLeavingDate(Date leavingDate) {
			this.leavingDate = leavingDate;
		}
		public Long getClassId() {
			return classId;
		}
		public void setClassId(Long classId) {
			this.classId = classId;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		
		public Long getAge() {
			return age;
		}
		public void setAge(Long age) {
			this.age = age;
		}
		public Long getLeavingReasonId() {
			return leavingReasonId;
		}
		public void setLeavingReasonId(Long leavingReasonId) {
			this.leavingReasonId = leavingReasonId;
		}
		public String getLeavingReasonValue() {
			return leavingReasonValue;
		}
		public void setLeavingReasonValue(String leavingReasonValue) {
			this.leavingReasonValue = leavingReasonValue;
		}
		
	
	
		
}
