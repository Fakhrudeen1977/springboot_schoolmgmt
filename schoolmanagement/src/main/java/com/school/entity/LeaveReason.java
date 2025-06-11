package com.school.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Leave_Reason")
public class LeaveReason implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	
	@Id
	@Column(name = "Leave_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEAVE_REASON_SEQ")
	@SequenceGenerator(sequenceName = "Leave_Reason_seq", allocationSize = 1, name = "LEAVE_REASON_SEQ")
	
	public Long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}
	@Column(name = "LEAVE_STATUSID")
	
	public String getLeave_statusId() {
		return leave_statusId;
	}
	public void setLeave_statusId(String leave_statusId) {
   }
	@Column(name = "LEAVE_STATUSVALUE")
	public String getLeave_statusValue() {
		return leave_statusValue;
	}
	public void setLeave_statusValue(String leave_statusValue) {
		this.leave_statusValue = leave_statusValue;
	}
	@Column(name = "YEAR")
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	@Column(name = "LEAVING_DATE")
	public Date getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(Date leavingDate) {
	}
	@Column(name = "CLASS_ID")
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	@Column(name = "CLASS_NAME")
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Column(name = "STUDENT_ID")
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	@Column(name = "STUDENT_NAME")
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Column(name = "LEAVING_REASONID")
	public Long getLeavingReasonId() {
		return leavingReasonId;
	}
	public void setLeavingReasonId(Long leavingReasonId) {
		this.leavingReasonId = leavingReasonId;
	}
	@Column(name = "LEAVING_REASONVALUE")
	public String getLeavingReasonValue() {
		return leavingReasonValue;
	}
	public void setLeavingReasonValue(String leavingReasonValue) {
		this.leavingReasonValue = leavingReasonValue;
	}
	@Column(name = "AGE")
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	
	}
