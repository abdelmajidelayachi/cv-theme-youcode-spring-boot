package com.example.cvtheme.services;

import com.example.cvtheme.entities.Teacher;
import com.example.cvtheme.payload.requests.TeacherRequest;
import com.example.cvtheme.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    /**
     * @return List<Teacher>
     */

    public List<Teacher> findAllTeacher(){
        return (List<Teacher>)teacherRepository.findAll();
    }

    /**
     * @param teacherId
     * @return Teacher
     */
    public Teacher findTeacherById(Long teacherId){
        return teacherRepository.findById(teacherId).orElse(null);
    }

    /**
     * @param promoId
     * @return Teacher
     */
    public Teacher findTeacherByPromoId(Long promoId){
        return teacherRepository.findTeacherByPromoId(promoId);
    }

    /**
     * @param request
     * @return Teacher
     */
    public Teacher saveTeacher(TeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setPromoId(request.getIdPromo());
        teacher.setFirstname(request.getFirstName());
        teacher.setLastname(request.getLastName());
        teacher.setEmail(request.getEmail());
        if(request.getPassword() != null){
            if(!request.getPasswordConfirm().equals(request.getPassword())){
                throw new RuntimeException("You must confirm your password");
            }
        }
        teacher.setPassword(request.getPassword());
        return teacherRepository.save(teacher);
    }

    /**
     * @param request
     * @param teacherId
     * @return Teacher
     */
    public Teacher updateTeacher(TeacherRequest request, Long teacherId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            if (request.getFirstName() != null) {
                teacher.setFirstname(request.getFirstName());
            }
            if (request.getLastName() != null) {
                teacher.setLastname(request.getLastName());
            }
            if (request.getEmail() != null) {
                teacher.setEmail(request.getEmail());
            }
            if (request.getIdPromo() != null) {
                teacher.setPromoId(request.getIdPromo());
            }
            teacher.setPromoId(request.getIdPromo());
            teacher.setLastname(request.getLastName());
            teacher.setEmail(request.getEmail());
            if (request.getNewPassword() != null) {
                if (!request.getConfirmNewPassword().equals(request.getNewPassword())) {
                    throw new RuntimeException("You must confirm your password");
                }
            }
            teacher.setPassword(request.getNewPassword());
        }
        return teacher;
    }

    /**
     * @param teacherId
     */
    public void deleteTeacher(Long teacherId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher != null) {
            teacherRepository.delete(teacher);
        } else {
            throw new RuntimeException("Teacher not found with id: " + teacherId);
        }
    }
}
