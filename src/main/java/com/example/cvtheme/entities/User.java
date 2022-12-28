package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String profilePicture;

    @Transient
    private String role;

    public User(Long id, String firstname, String lastname, String email, String profilePicture) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profilePicture = profilePicture;
    }
}
