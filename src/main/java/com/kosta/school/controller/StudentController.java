package com.kosta.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.school.domain.Enrolment;
import com.kosta.school.domain.Student;
import com.kosta.school.service.EnrolmentService;
import com.kosta.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final EnrolmentService enrolmentService;

    public StudentController(StudentService studentService, EnrolmentService enrolmentService) {
        this.studentService = studentService;
        this.enrolmentService = enrolmentService;
    }

    @GetMapping
    public List<Student> fetchStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student fetchStudent(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student insertStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updatStudent(
        @PathVariable("id") Long id,
        @RequestBody Student student
    ) {
        // Mapping
        Student before = studentService.findById(id);
        before.setName(student.getName());
        // Update
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
    }

    @GetMapping("/{id}/enrollment")
    public List<Enrolment> fetchStudentEnrolments(@PathVariable("id") Long id) {
        return enrolmentService.findStudentEnrolments(id);
    }

}
