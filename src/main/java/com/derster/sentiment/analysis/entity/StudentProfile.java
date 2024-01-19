package com.derster.sentiment.analysis.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bio;

    public StudentProfile() {
    }

    public StudentProfile(String bio) {
        this.bio = bio;
    }
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
}
