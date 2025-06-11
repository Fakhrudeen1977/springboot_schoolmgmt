package com.school.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Leaveing_Reason")
public class LeavingReason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LeavingReason() {
		// TODO Auto-generated constructor stub
	}
	
	private Long leavingReasonId;
    private String leavingReasonValue;
    
    @Id
	@Column(name = "LEAVE_REASONID ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LEAVING_REASON_SEQ")
	@SequenceGenerator(sequenceName = "Leaving_Reason_seq", allocationSize = 1, name = "LEAVING_REASON_SEQ")
	public Long getLeavingReasonId() {
		return leavingReasonId;
	}
	public void setLeavingReasonId(Long leavingReasonId) {
		this.leavingReasonId = leavingReasonId;
	}
	
	@Column(name = "LEAVE_REASONVALUE ")
	public String getLeavingReasonValue() {
		return leavingReasonValue;
	}
	public void setLeavingReasonValue(String leavingReasonValue) {
		this.leavingReasonValue = leavingReasonValue;
	}

}
