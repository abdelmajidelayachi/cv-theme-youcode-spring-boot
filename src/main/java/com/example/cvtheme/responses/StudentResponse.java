package com.example.cvtheme.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {
    private String studentReferenceName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private PromoResponse promo;

}
