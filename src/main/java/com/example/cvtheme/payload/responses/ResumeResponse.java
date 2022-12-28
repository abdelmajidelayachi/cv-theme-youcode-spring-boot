package com.example.cvtheme.payload.responses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ResumeResponse{

    private String name;
    private Long studentId;
    private String fileName;
}
