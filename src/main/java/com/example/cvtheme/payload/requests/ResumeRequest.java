package com.example.cvtheme.payload.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResumeRequest {
    private String name;
    private Long studentId;
    private String fileName;
}
