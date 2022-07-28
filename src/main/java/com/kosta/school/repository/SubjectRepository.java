package com.kosta.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.school.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {}
