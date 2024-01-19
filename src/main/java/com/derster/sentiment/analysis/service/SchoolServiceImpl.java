package com.derster.sentiment.analysis.service;

import com.derster.sentiment.analysis.dto.SchoolDto;
import com.derster.sentiment.analysis.mapper.SchoolMapper;
import com.derster.sentiment.analysis.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService{

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDto saveSchool(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    @Override
    public List<SchoolDto> findAll() {
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
