package com.assignment.esql.domain.repository;

import com.assignment.esql.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}