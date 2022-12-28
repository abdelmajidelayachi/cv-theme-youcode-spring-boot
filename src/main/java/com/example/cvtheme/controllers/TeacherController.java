package com.example.cvtheme.controllers;

import com.example.cvtheme.payload.requests.TeacherRequest;
import com.example.cvtheme.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getTeacher(){
        return ResponseEntity.ok(Map.of("status",true, "message", "Teacher found successfully", "data", teacherService.findAllTeacher()));
    }

    @GetMapping(path = "{teacherId}")
    public ResponseEntity<Map<String, Object>> getTeacherById(@PathVariable("teacherId") Long teacherId){
        return ResponseEntity.ok(Map.of("status",true, "message", "Teacher found successfully", "data", teacherService.findTeacherById(teacherId)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> saveTeacher(@RequestBody TeacherRequest teacherRequest){
        return ResponseEntity.ok(Map.of("status",true, "message", "Teacher saved successfully", "data", teacherService.saveTeacher(teacherRequest)));
    }

    @PutMapping(path = "{teacherId}")
    public ResponseEntity<Map<String, Object>> updateTeacher(@RequestBody TeacherRequest teacherRequest, @PathVariable("teacherId") Long id){
        return ResponseEntity.ok(Map.of("status",true, "message", "Teacher updated successfully", "data", teacherService.updateTeacher(teacherRequest, id)));
    }

    @DeleteMapping(path = "{teacherId}")
    public ResponseEntity<Map<String, Object>> deleteTeacher(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok(Map.of("status",true, "message", "Teacher deleted successfully"));
    }


}

