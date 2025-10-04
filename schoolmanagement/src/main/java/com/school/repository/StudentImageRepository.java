package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.entity.Student;

public interface StudentImageRepository extends JpaRepository<Student, Long> {

}
