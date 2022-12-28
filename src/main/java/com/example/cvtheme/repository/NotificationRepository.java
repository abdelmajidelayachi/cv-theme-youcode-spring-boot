package com.example.cvtheme.repository;

import com.example.cvtheme.entities.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

    List<Notification> findNotificationsByStudentId(Long studentId);
}
