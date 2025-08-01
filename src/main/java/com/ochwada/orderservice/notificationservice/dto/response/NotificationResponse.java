package com.ochwada.orderservice.notificationservice.dto.response;


import com.ochwada.orderservice.notificationservice.model.Type;

import java.time.LocalDateTime;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.dto.response
 * File: NotificationResponse.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 3:50 PM
 * Description: Response DTO for a sent notification.
 * *******************************************************
 */


/**
 * This class represents the response returned to the client after a notification is successfully processed and
 * optionally stored. It contains metadata such as the notification type, recipient, content, and timestamp.
 * </p>
 */
public record NotificationResponse(

        /**
         * Unique identifier of the notification.
         */
        String id,

        /**
         * Type of the notification (e.g., "email", "sms").
         */
        Type type,

        /**
         * Recipient of the notification.
         * Can be a valid email address or phone number.
         */
        String to,

        /**
         * The actual message content sent in the notification.
         */
        String message,

        /**
         * The date and time when the notification was sent.
         */
        LocalDateTime sentAt
) {
}
