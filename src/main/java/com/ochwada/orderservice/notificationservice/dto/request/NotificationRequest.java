package com.ochwada.orderservice.notificationservice.dto.request;


import com.ochwada.orderservice.notificationservice.model.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.dto.request
 * File: NotificationRequest.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 3:33 PM
 * Description: Represents  request to trigger a notification.
 * - This request contains the type of notification, the recipient (email or phone number), and the message to be sent.
 * - Validation is applied to ensure data integrity.
 * *******************************************************
 */

public record NotificationRequest(
        /**
         * The type of notification delivery.
         * Must be either EMAIL or SMS.
         */
        @NotBlank Type type,


        /**
         * The recipient of the notification.
         * Must be a valid email address or phone number (10–15 digits, optional '+' prefix).
         */
        @NotBlank
        @Pattern(
                regexp = "^(\\+?[0-9]{10,15}|[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$",
                message = "Recipient must be a valid phone number or email address"
        )
        String to,


        /**
         * The content of the notification message.
         * Must not be blank.
         */
        @NotBlank String message
) {
}
