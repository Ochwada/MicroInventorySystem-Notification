package com.ochwada.orderservice.notificationservice.repository;


import com.ochwada.orderservice.notificationservice.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.repository
 * File: NotificationRepository.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 4:06 PM
 * Description: Repository interface to interact with MongoDB Atlas.
 * Objective:
 * *******************************************************
 */


public interface NotificationRepository extends MongoRepository<Notification, String> {
    /**==========================================================
     1. CRUD Methods
     ========================================================== */

    /**==========================================================
     2. Customerized Methods
     ========================================================== */
}
