package com.example.cvtheme.payload.requests;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PromoRequest {

    private String name;
    private String major;
    private String year;
}
