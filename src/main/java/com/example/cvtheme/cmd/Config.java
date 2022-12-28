package com.example.cvtheme.cmd;

import com.example.cvtheme.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args -> {

        };
    }
}
