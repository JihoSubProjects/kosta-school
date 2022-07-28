package com.kosta.school.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.kosta.school.domain.Syllabus;
import com.kosta.school.repository.SyllabusRepository;

@Service
public class SyllabusService {

    private final SyllabusRepository syllabusRepository;

    public SyllabusService(SyllabusRepository syllabusRepository) {
        this.syllabusRepository = syllabusRepository;
    }

    public List<Syllabus> findAll() {
        return syllabusRepository.findAll();
    }

    public Syllabus findById(Long id) {
        return syllabusRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Syllabus save(Syllabus syllabus) {
        return syllabusRepository.save(syllabus);
    }

    public void delete(Long id) {
        syllabusRepository.deleteById(id);
    }

}
