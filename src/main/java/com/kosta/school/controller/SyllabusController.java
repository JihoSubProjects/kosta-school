package com.kosta.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.school.domain.Professor;
import com.kosta.school.domain.Subject;
import com.kosta.school.domain.Syllabus;
import com.kosta.school.service.ProfessorService;
import com.kosta.school.service.SubjectService;
import com.kosta.school.service.SyllabusService;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

    private final SyllabusService syllabusService;
    private final ProfessorService professorService;
    private final SubjectService subjectService;

    public SyllabusController(SyllabusService syllabusService, ProfessorService professorService, SubjectService subjectService) {
        this.syllabusService = syllabusService;
        this.professorService = professorService;
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Syllabus> fetchAllSyllabus() {
        return syllabusService.findAll();
    }

    @GetMapping("/{id}")
    public Syllabus fetchSyllabus(Long id) {
        return syllabusService.findById(id);
    }

    @PostMapping
    public Syllabus insertSyllabus(
        @RequestParam("professor_id") Long professorId,
        @RequestParam("subject_id") Long subjectId,
        @RequestBody Syllabus syllabus
    ) {
        Professor professor = professorService.findById(professorId);
        Subject subject = subjectService.findById(subjectId);
        syllabus.setProfessor(professor);
        syllabus.setSubject(subject);
        return syllabusService.save(syllabus);
    }

    @PutMapping("/{id}")
    public Syllabus updateSyllabus(
        @PathVariable("id") Long id,
        @RequestParam("professor_id") Long professorId,
        @RequestParam("subject_id") Long subjectId,
        @RequestBody Syllabus newSyllabus
    ) {
        // find
        Syllabus syllabus = syllabusService.findById(id);
        Professor professor = professorService.findById(professorId);
        Subject subject = subjectService.findById(subjectId);
        // mapping
        syllabus.setProfessor(professor);
        syllabus.setSubject(subject);
        syllabus.setDay(newSyllabus.getDay());
        syllabus.setTime(newSyllabus.getTime());
        syllabus.setLocation(newSyllabus.getLocation());
        // update
        return syllabusService.save(syllabus);
    }

    @DeleteMapping("/{id}")
    public void deleteSyllabus(@PathVariable("id") Long id) {
        syllabusService.delete(id);
    }

}
