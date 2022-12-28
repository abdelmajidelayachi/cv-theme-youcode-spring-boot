package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "teachers")
public class TeacherEntity extends User {
    @Column(nullable = false, unique = true)
    private String teacherReferenceName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promoId", referencedColumnName = "id", nullable = false)
    private PromoEntity promo;
}
