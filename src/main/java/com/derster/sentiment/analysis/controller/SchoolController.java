package com.derster.sentiment.analysis.controller;

import com.derster.sentiment.analysis.entity.School;
import com.derster.sentiment.analysis.repository.SchoolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(@RequestBody School school){

        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }
}
