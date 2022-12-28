package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "motivationLetters")
public class MotivationLetterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String letter;
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private StudentEntity student;
    @OneToMany(mappedBy = "letter")
    private List<MotivationLetterEntity> letters;
}
