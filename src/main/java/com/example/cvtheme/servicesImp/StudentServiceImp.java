package com.example.cvtheme.servicesImp;

import com.example.cvtheme.entities.PromoEntity;
import com.example.cvtheme.entities.StudentEntity;
import com.example.cvtheme.repositories.PromoRepository;
import com.example.cvtheme.repositories.StudentRepository;
import com.example.cvtheme.services.StudentService;
import com.example.cvtheme.shared.dto.StudentDto;
import com.example.cvtheme.shared.enums.StudentStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PromoRepository promoRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public StudentDto createStudent(StudentDto student) {
        // encrypt the password
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        // create studentReferenceName
        student.setStudentReferenceName((student.getFirstName()+"_"+student.getLastName()).toLowerCase());
        student.setStatus(StudentStatus.NO_STATUS);
        PromoEntity promo = promoRepository.findByPromoReferenceName(student.getPromoReferenceName());
        student.setPromoId(promo.getId());
        student.setPromo(promo);
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);

        StudentEntity newStudent = studentRepository.save(studentEntity);
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(newStudent, studentDto);
        return studentDto;
    }
}
