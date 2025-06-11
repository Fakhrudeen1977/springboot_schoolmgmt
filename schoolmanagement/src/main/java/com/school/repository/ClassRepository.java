package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entity.ClassDetails;

public interface ClassRepository extends JpaRepository<ClassDetails, Long>{

}
