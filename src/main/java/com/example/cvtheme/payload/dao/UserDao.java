package com.example.cvtheme.payload.dao;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Repository
public class UserDao {

    private final static List<UserDetails> userDetailsList = Arrays.asList(
            new User(
                    "majid@gmail.com",
                    "1234",
                    Collections.singletonList(() -> "ROLE_ADMIN")
            ),
            new User(
                    "mohcine@gmail.com",
                    "1234",
                    Collections.singletonList(() -> "ROLE_USER")
            )
    );

    public UserDetails getUserByEmail(String email){
        return userDetailsList.stream()
                .filter(userDetails -> userDetails.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}
