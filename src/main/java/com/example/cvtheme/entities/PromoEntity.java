package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "promos")
public class PromoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String promoReferenceName;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private String major;
    @OneToOne(mappedBy = "promo")
    private TeacherEntity teacher;
    @OneToMany(mappedBy = "promo")
    private List<StudentEntity> students;
}
