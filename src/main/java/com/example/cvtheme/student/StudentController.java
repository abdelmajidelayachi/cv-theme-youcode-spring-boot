package com.example.cvtheme.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.findAllStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.saveStudent(student);
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
