package com.example.cvtheme.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@RequiredArgsConstructor
@Getter
@Setter
public class Teacher extends User {

    @Column(name = "promo_id")
    private Long promoId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promo_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Promo promo;
}
