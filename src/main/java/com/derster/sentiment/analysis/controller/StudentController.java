package com.derster.sentiment.analysis.controller;

import com.derster.sentiment.analysis.dto.StudentResponseDTO;
import com.derster.sentiment.analysis.entity.Sa;
import com.derster.sentiment.analysis.entity.School;
import com.derster.sentiment.analysis.entity.Student;
import com.derster.sentiment.analysis.dto.StudentDTO;
import com.derster.sentiment.analysis.mapper.StudentMapper;
import com.derster.sentiment.analysis.repository.StudentRepository;
import com.derster.sentiment.analysis.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/sa", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentDTO dto){
        return studentService.saveStudent(dto);
    }
    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Optional<Student> findStudentById(@PathVariable Integer studentId){
        return studentService.findStudentById(studentId);
    }

    @GetMapping("/students/search/{studentName}")
    public List<Student> findStudentByName(@PathVariable String studentName){
        return studentService.findStudentByName(studentName);
    }
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Integer studentId){
         studentService.deleteStudent(studentId);
    }

    @GetMapping
    public List<Sa> search(){
        return List.of(
                new Sa(1, "Record Message", 0),
                new Sa(2, "Record Message 2", 1)
        );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
