package com.example.cvtheme;

import com.example.cvtheme.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class CvthemeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvthemeApplication.class, args);
    }

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> hello() {
        return List.of(
                new Student(
                        1L,
                        "Abdelmajid",
                        "email@gmail.com",
                        LocalDate.of(2001, Month.APRIL,02)
                )
        );
    }

}
