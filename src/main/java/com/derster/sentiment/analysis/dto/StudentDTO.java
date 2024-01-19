package com.derster.sentiment.analysis.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty(message = "Ce champ est obligatoire")
        String firstName,
        @NotEmpty(message = "Ce champ est obligatoire")
        String lastName,
        String email,
        Integer schoolId
) {
}
