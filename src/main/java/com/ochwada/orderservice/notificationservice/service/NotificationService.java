package com.ochwada.orderservice.notificationservice.service;


import com.ochwada.orderservice.notificationservice.dto.request.NotificationRequest;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.service
 * File: NotificationService.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 5:42 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public interface NotificationService {
    void send(NotificationRequest request);
}
