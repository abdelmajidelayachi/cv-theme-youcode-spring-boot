package com.example.cvtheme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Table(name = "comments")
@Getter
@Setter
@RequiredArgsConstructor
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "cme_id")
    private Long cmeId;

    enum CommentType{
        MOTIVATION_LETTER,
        RESUME
    }

    public void setCommentType(String type) {
        this.commentType = CommentType.valueOf(type);
    }

    @Column(name = "comment_type")
    private CommentType commentType;

    @Column(name = "resume_id")
    private Long resumeId;

    @Column(name = "motivation_letter_id")
    private Long motivationLetterId;


    @Column(name = "updated_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cme_id", insertable = false, updatable = false)
    private Cme cme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motivation_letter_id", insertable = false, updatable = false)
    private MotivationLetter motivationLetter;
}

