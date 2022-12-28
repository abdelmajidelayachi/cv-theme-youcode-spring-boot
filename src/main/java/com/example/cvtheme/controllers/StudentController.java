package com.example.cvtheme.controllers;

import com.example.cvtheme.entities.Student;
import com.example.cvtheme.payload.requests.StudentRequest;
import com.example.cvtheme.repository.StudentRepository;
import com.example.cvtheme.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Map<String,Object>> getStudent() {
        return ResponseEntity.ok(Map.of("status", true, "message", "Student found successfully", "data", studentService.findAllStudent()));
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentRequest studentRequest){
        studentService.saveStudent(studentRequest);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@RequestParam(required = false) String email, @RequestParam(required=false) String name, @PathVariable("studentId") Long id){
        studentService.updateStudent(name, email, id);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
