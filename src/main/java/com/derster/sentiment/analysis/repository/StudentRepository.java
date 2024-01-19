package com.derster.sentiment.analysis.repository;

import com.derster.sentiment.analysis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstNameContaining(String p);
}
