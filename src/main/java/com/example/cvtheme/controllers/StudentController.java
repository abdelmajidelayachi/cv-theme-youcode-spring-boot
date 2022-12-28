package com.example.cvtheme.controllers;

import com.example.cvtheme.requests.StudentRequest;
import com.example.cvtheme.responses.PromoResponse;
import com.example.cvtheme.responses.StudentResponse;
import com.example.cvtheme.services.StudentService;
import com.example.cvtheme.shared.dto.StudentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public String getUsers() {
        System.out.println("getUsers");
        return "get users";
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(studentRequest, studentDto);
        StudentDto createStudent = studentService.createStudent(studentDto);
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(createStudent, studentResponse);
        studentResponse.setStatus(createStudent.getStatus().name());
//        studentResponse.setPromo(createStudent.getPromo());
        PromoResponse promoResponse = new PromoResponse();
        BeanUtils.copyProperties(createStudent.getPromo(), promoResponse);
        studentResponse.setPromo(promoResponse);
        return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
    }
}
