package com.derster.sentiment.analysis.mapper;

import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.School;
import com.derster.sentiment.analysis.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO toStudentResponseDto(Student student){

        return new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
