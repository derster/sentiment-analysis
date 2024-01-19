package com.derster.sentiment.analysis.controller;

import com.derster.sentiment.analysis.dto.SchoolDto;
import com.derster.sentiment.analysis.entity.School;
import com.derster.sentiment.analysis.repository.SchoolRepository;
import com.derster.sentiment.analysis.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolDto saveSchool(@RequestBody SchoolDto dto){
        return schoolService.saveSchool(dto);
    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolService.findAll();
    }
}
