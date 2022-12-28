package com.example.cvtheme.entities;

import com.example.cvtheme.shared.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "students")
public class StudentEntity extends User {
    @Column(nullable = false, unique = true)
    private String studentReferenceName;
    @Column(nullable = false)
    private StudentStatus status;
    @ManyToOne
    @JoinColumn(name = "promoId", nullable = false)
    private PromoEntity promo;
    @OneToMany(mappedBy = "student")
    private List<ResumeEntity> resumes;
    @OneToMany(mappedBy = "student")
    private List<MotivationLetterEntity> letters;
}
