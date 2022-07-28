package com.kosta.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.school.domain.Enrolment;
import com.kosta.school.domain.Student;
import com.kosta.school.domain.Syllabus;
import com.kosta.school.service.EnrolmentService;
import com.kosta.school.service.StudentService;
import com.kosta.school.service.SyllabusService;

@RestController
@RequestMapping("/enrolment")
public class EnrolmentController {

    private final EnrolmentService enrolmentService;
    private final StudentService studentService;
    private final SyllabusService syllabusService;

    public EnrolmentController(EnrolmentService enrolmentService, StudentService studentService, SyllabusService syllabusService) {
        this.enrolmentService = enrolmentService;
        this.studentService = studentService;
        this.syllabusService = syllabusService;
    }

    @GetMapping
    public List<Enrolment> fetchAllEnrolment() {
        return enrolmentService.findAll();
    }

    @GetMapping("/{id}")
    public Enrolment fetchEnrolment(@PathVariable("id") Long id) {
        return enrolmentService.findById(id);
    }

    @PostMapping
    public Enrolment insertEnrolment(
        @RequestParam("student_id") Long studentId,
        @RequestParam("syllabus_id") Long syllabusId,
        @RequestBody Enrolment enrolment
    ) {
        Student student = studentService.findById(studentId);
        Syllabus syllabus = syllabusService.findById(syllabusId);
        enrolment.setStudent(student);
        enrolment.setSyllabus(syllabus);
        return enrolmentService.save(enrolment);
    }

    @PutMapping("/{id}")
    public Enrolment updateEnrolment(
        @PathVariable("id") Long id,
        @RequestParam("student_id") Long studentId,
        @RequestParam("syllabus_id") Long syllabusId,
        @RequestBody Enrolment newEnrolment
    ) {
        // find
        Enrolment enrolment = enrolmentService.findById(id);
        Student student = studentService.findById(studentId);
        Syllabus syllabus = syllabusService.findById(syllabusId);
        // mapping
        enrolment.setStudent(student);
        enrolment.setSyllabus(syllabus);
        enrolment.setGrade(newEnrolment.getGrade());
        // update
        return enrolmentService.save(enrolment);
    }

}
