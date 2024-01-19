package com.derster.sentiment.analysis.mapper;

import com.derster.sentiment.analysis.dto.SchoolDto;
import com.derster.sentiment.analysis.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto dto) {

        return new School(dto.name());

    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
