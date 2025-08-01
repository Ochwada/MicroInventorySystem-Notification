package com.ochwada.orderservice.notificationservice.mapper;


import com.ochwada.orderservice.notificationservice.dto.request.NotificationRequest;
import com.ochwada.orderservice.notificationservice.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.mapper
 * File: NotificationMapper.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 6:12 PM
 * Description:
 * Objective:
 * *******************************************************
 */

@Component
@RequiredArgsConstructor
public class NotificationMapper {


    /**
     * Converts a NotificationRequest DTO to a Notification entity.
     *
     * @param request the incoming request DTO
     * @return a Notification entity ready to persist to MongoDB
     */
    public static Notification toEntity(NotificationRequest request) {
        return new Notification(
                null,
                request.type(),
                request.to(),
                request.message(),
                LocalDateTime.now()        
        );
    }
}
