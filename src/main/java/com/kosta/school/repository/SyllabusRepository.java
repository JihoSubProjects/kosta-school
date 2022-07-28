package com.kosta.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.school.domain.Syllabus;

@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Long> {}
