package com.derster.sentiment.analysis.service;

import com.derster.sentiment.analysis.dto.SchoolDto;

import java.util.List;

public interface SchoolService {
    SchoolDto saveSchool(SchoolDto dto);
    List<SchoolDto> findAll();
}
