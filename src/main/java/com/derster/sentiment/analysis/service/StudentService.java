package com.derster.sentiment.analysis.service;

import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.Student;
import com.derster.sentiment.analysis.mapper.StudentMapper;
import com.derster.sentiment.analysis.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentResponseDTO saveStudent(StudentDTO studentDTO);
    List<Student> findAllStudents();
    Optional<Student> findStudentById(Integer studentId);
    List<Student> findStudentByName(String studentName);
    void deleteStudent(Integer studentId);
}
