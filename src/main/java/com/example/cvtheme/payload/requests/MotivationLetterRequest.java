package com.example.cvtheme.payload.requests;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MotivationLetterRequest {
    private String name;
    private Long studentId;
    private String content;

}
