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
@Table(name = "promo")
public class Promo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String year;

    private String major;


    @OneToOne(mappedBy = "promo")
    private Teacher teacher;

    @OneToMany(mappedBy = "promo")
    private Set<Student> student;
}
