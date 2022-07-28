package com.kosta.school.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.kosta.school.domain.Enrolment;
import com.kosta.school.repository.EnrolmentRepository;

@Service
public class EnrolmentService {

    private final EnrolmentRepository enrolmentRepository;

    public EnrolmentService(EnrolmentRepository enrolmentRepository) {
        this.enrolmentRepository = enrolmentRepository;
    }

    public List<Enrolment> findStudentEnrolments(Long studentId) {
        return enrolmentRepository.findAllByStudentId(studentId);
    }

    public Enrolment findById(Long id) {
        return enrolmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Enrolment save(Enrolment enrolment) {
        return enrolmentRepository.save(enrolment);
    }

    public void delete(Long id) {
        enrolmentRepository.deleteById(id);
    }

    public List<Enrolment> findAll() {
        return enrolmentRepository.findAll();
    }

}
