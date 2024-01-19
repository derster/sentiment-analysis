package com.derster.sentiment.analysis.service;

import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.Student;
import com.derster.sentiment.analysis.mapper.StudentMapper;
import com.derster.sentiment.analysis.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponseDTO saveStudent(StudentDTO dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findStudentById(Integer studentId) {
        return Optional.of(studentRepository.findById(studentId).orElse(new Student()));
    }

    @Override
    public List<Student> findStudentByName(String studentName) {
        return studentRepository.findAllByFirstNameContaining(studentName);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
