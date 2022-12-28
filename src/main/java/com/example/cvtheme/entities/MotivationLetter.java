package com.example.cvtheme.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "motivation_letter")
public class MotivationLetter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    private String letterName;

    @Column(columnDefinition = "TEXT")
    private String letterContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @OneToMany(mappedBy = "motivationLetter")
    private Set<Comment> comments;

}
