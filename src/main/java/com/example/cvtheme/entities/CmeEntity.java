package com.example.cvtheme.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "cmes")
public class CmeEntity extends User {
    @Column(nullable = false, unique = true)
    private String cmeReferenceName;
    @Column(nullable = false)
    @OneToMany(mappedBy = "cme")
    private List<CommentEntity> comments;

}
