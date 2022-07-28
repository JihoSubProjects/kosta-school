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

import com.kosta.school.domain.Subject;
import com.kosta.school.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> fetchSubjects() {
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public Subject fetchSubject(@PathVariable("id") Long id) {
        return subjectService.findById(id);
    }

    @PostMapping
    public Subject insertSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable("id") Long id, @RequestBody Subject newSubject) {
        // mapping
        Subject subject = subjectService.findById(id);
        subject.setName(newSubject.getName());
        // update
        return subjectService.save(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable("id") Long id) {
        subjectService.delete(id);
    }

}
