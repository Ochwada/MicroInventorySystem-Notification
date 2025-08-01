package com.ochwada.orderservice.notificationservice.service.impl;


import com.ochwada.orderservice.notificationservice.dto.request.NotificationRequest;
import com.ochwada.orderservice.notificationservice.mapper.NotificationMapper;
import com.ochwada.orderservice.notificationservice.model.Notification;
import com.ochwada.orderservice.notificationservice.repository.NotificationRepository;
import com.ochwada.orderservice.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.service.impl
 * File: NotificationServiceImpl.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 6:02 PM
 * Description: Service implementation for sending notifications.
 * *******************************************************
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    @Override
    public void send(NotificationRequest request) {
        // Log to console
        log.info("📨 Notification sent via {} to {}: {}",
                request.type(), request.to(), request.message());

        // Save to MongoDB
        Notification notification = NotificationMapper.toEntity(request);
        repository.save(notification);

    }
}
