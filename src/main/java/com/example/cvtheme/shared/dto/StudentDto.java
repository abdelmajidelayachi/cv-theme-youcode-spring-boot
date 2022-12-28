package com.example.cvtheme.shared.dto;

import com.example.cvtheme.entities.PromoEntity;
import com.example.cvtheme.shared.enums.StudentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String studentReferenceName;
    private String firstName;
    private String lastName;
    private StudentStatus status;
    private String email;
    private String password;
    private Long promoId;
    private String promoReferenceName;
    private PromoEntity promo;
}
