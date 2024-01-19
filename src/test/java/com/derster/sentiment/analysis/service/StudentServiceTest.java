package com.derster.sentiment.analysis.service;

import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.Student;
import com.derster.sentiment.analysis.mapper.StudentMapper;
import com.derster.sentiment.analysis.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceTest {

    // Which service we went to test
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_sucessfully_save_a_student(){
        //Given
        StudentDTO dto = new StudentDTO(
                "Jane",
                "Smith",
                "jane@gmail.com",
                1);

        Student student = new Student(
                "Jane",
                "Smith",
                "jane@gmail.com",
                20
        );

        Student saveStudent = new Student(
                "Jane",
                "Smith",
                "jane@gmail.com",
                20
        );
        saveStudent.setId(1);


        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(saveStudent);
        when(studentMapper.toStudentResponseDto(saveStudent)).thenReturn(new StudentResponseDTO(
                "Jane",
                "Smith",
                "jane@gmail.com"
        ));

        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstName(), responseDTO.firstName());
        assertEquals(dto.lastName(), responseDTO.lastName());
        assertEquals(dto.email(), responseDTO.email());
    }

}