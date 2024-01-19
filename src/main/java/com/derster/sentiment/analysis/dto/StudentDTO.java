package com.derster.sentiment.analysis.dto;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {
}
