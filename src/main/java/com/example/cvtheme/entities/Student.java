package com.example.cvtheme.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@RequiredArgsConstructor

public class Student extends User{

    @Column(name = "promo_id")
    Long promoId;
    enum Status {
        NONE, HAS_INTERNSHIP, HAS_JOB
    }
    Status status;

    public Student(Long id, String firstname,String lastname, String email, String password, String profilePicture, Long promoId, Status status) {
        super(id, firstname, lastname, email, profilePicture);
        this.promoId = promoId;
        this.status = status;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promo_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Promo promo;

    @OneToMany(mappedBy = "student")
    private Set<Resume> resumes;

    @OneToMany(mappedBy = "student")
    private Set<MotivationLetter> motivationLetters;

    @OneToMany(mappedBy = "student")
    private Set<Notification> notifications;

}
