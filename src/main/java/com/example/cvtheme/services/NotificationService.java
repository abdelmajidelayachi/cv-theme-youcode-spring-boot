package com.example.cvtheme.services;

import com.example.cvtheme.entities.Notification;
import com.example.cvtheme.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    /**
     * @param studentId
     * @return List<Notification>
     */
    public List<Notification> findAllNotificationByStudentId(Long studentId){
        return notificationRepository.findNotificationsByStudentId(studentId);
    }

    /**
     * @param notificationId
     * @return Notification
     */
    @Transactional
    public Notification changeNotificationStatusToSeen(Long notificationId){
        Notification notification = notificationRepository.findById(notificationId).orElse(null);
        if (notification != null){
            notification.setSeen(true);
        }
        return notification;
    }


}
