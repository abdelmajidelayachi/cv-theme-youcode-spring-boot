package com.example.cvtheme.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository  = studentRepository;
    }
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        boolean isStudentExists = studentRepository.existsStudentByEmail(student.getEmail());
        if (isStudentExists) {
            throw new IllegalStateException("Email is taken");
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            studentRepository.deleteById(id);
        else
            throw new IllegalStateException("this student is not exist!!");
    }

    @Transactional
    public void updateStudent(String name, String email, Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("Student with id = "+ id + " doesn't exist" ));
        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if (email != null && !email.isEmpty() && !Objects.equals(student.getName(), email)){
            student.setEmail(email);
        }

    }

    public Student loadUserByUsername(String userEmail) {
        return studentRepository.findStudentByEmail(userEmail);
    }
}
