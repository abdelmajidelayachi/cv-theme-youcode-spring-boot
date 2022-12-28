package com.example.cvtheme.controllers;

import com.example.cvtheme.payload.requests.NotificationRequest;
import com.example.cvtheme.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Map<String, Object>> findAllNotificationByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(Map.of("success", true, "data", notificationService.findAllNotificationByStudentId(studentId)));
    }

    @PostMapping("/{notificationId}")
    public ResponseEntity<Map<String, Object>> notificationHasSeen(@PathVariable Long notificationId){
        return ResponseEntity.ok(Map.of("success", true, "data", notificationService.changeNotificationStatusToSeen(notificationId)));
    }
}
