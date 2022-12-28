package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cme")
@NoArgsConstructor
public class Cme extends User {

    public Cme(Long id, String firstname, String lastname, String email, String profilePicture ){
        super(id, firstname, lastname, email, profilePicture);
    }

    @OneToMany(mappedBy = "cme")
    private Set<Comment> comments;
}
