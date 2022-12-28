package com.example.cvtheme.payload.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.yaml.snakeyaml.comments.CommentType;

@Getter
@Setter
@RequiredArgsConstructor
public class CommentRequest {
    private Long cmeId;
    private String type;
    private String content;
    private Long letterId;
    private Long cvId;
}
