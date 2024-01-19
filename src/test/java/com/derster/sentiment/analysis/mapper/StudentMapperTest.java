package com.derster.sentiment.analysis.mapper;

import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the BeforeAll method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the AfterAll method");
    }



    @AfterEach
    void  tearDown() {
        System.out.println("Inside the AfterEach method");
    }

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDTO dto = new StudentDTO(
                "John",
                "Doe",
                "jdoe@gmail.com",
                1);
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldthrow_null_pointer_exception_when_studentDto_is_null(){
        var msg = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("Le dto Student ne doit pas être null", msg.getMessage());
    }

    @Test
    public void shouldMapStudentStudentResponseDto(){

        // Given
        Student student = new Student(
                "Jane",
                "Smith",
                "jane@gmail.com",
                20
        );
        // When
        StudentResponseDTO response = mapper.toStudentResponseDto(student);

        // Then
        assertEquals(response.firstName(), student.getFirstName());
        assertEquals(response.lastName(), student.getLastName());
        assertEquals(response.email(), student.getEmail());

    }
}