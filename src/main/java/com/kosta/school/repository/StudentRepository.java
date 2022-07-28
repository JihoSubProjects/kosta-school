package com.kosta.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.school.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
