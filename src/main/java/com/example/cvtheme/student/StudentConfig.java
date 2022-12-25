package com.example.cvtheme.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args -> {
            Student abdelmajid = new Student("Abdelmajid", "elayachi@gmail.com", LocalDate.of(2001, Month.JANUARY, 22));
            Student anas = new Student("anas", "anas@gmail.com", LocalDate.of(2011, Month.JANUARY, 22) );
            repository.saveAll(List.of(abdelmajid
            , anas));
        };
    }
}
