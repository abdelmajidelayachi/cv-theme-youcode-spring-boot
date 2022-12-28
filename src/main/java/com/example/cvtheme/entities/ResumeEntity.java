package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "resumes")
public class ResumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cvName;
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private StudentEntity student;
    @OneToMany(mappedBy = "resume")
    private List<CommentEntity> comments;

}
