package com.derster.sentiment.analysis.controller;

import com.derster.sentiment.analysis.entity.Sa;
import com.derster.sentiment.analysis.entity.School;
import com.derster.sentiment.analysis.entity.Student;
import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/sa", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody StudentDTO dto){
        var student = toStudent(dto);
        return studentRepository.save(student);
    }
    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> findStudentById(@PathVariable Integer studentId){
        return Optional.of(studentRepository.findById(studentId).orElse(new Student()));
    }

    @GetMapping("/students/search/{studentName}")
    public List<Student> findStudentByName(@PathVariable String studentName){
        return studentRepository.findAllByFirstNameContaining(studentName);
    }
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Integer studentId){
         studentRepository.deleteById(studentId);
    }

    @GetMapping
    public List<Sa> search(){
        return List.of(
                new Sa(1, "Record Message", 0),
                new Sa(2, "Record Message 2", 1)
        );
    }


    private Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }
}
