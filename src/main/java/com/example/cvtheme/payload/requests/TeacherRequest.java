package com.example.cvtheme.payload.requests;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TeacherRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
    private String password;
    private String passwordConfirm;
    private String profilePicture;
    private Long idPromo;
}
