package com.kosta.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.school.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {}
