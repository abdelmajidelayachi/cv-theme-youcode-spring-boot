package com.example.cvtheme.entities;

import com.example.cvtheme.shared.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cmeId", nullable = false)
    private CmeEntity cme;
    @ManyToOne
    @JoinColumn(name = "resumeId", nullable = false)
    private ResumeEntity resume;
    @ManyToOne
    @JoinColumn(name = "letterId", nullable = false)
    private MotivationLetterEntity motivationLetter;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private DocumentType documentType;
    @Column(nullable = false)
    private Timestamp date;
    @OneToOne(mappedBy = "comment")
    private NotificationEntity notification;
    
}
