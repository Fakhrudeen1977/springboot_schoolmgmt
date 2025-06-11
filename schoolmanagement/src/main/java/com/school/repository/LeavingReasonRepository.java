package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.LeavingReason;

@Repository
public interface LeavingReasonRepository extends JpaRepository<LeavingReason, Long> {

}
