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

import com.kosta.school.domain.Professor;
import com.kosta.school.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> fetchProfessors() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    public Professor fetchProfessor(@PathVariable("id") Long id) {
        return professorService.findById(id);
    }

    @PostMapping
    public Professor insertProfessor(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor newProfessor) {
        // mapping
        Professor professor = professorService.findById(id);
        professor.setName(newProfessor.getName());
        // update
        return professorService.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable("id") Long id) {
        professorService.delete(id);
    }

}
