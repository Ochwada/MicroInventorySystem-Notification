package com.ochwada.orderservice.notificationservice.model;


import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.model
 * File: Notification.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 3:12 PM
 * Description: Represent Notification document to be stored in the MongoDB i.e Domain model for a notification sent.
 * - Represents a notification sent within the system.
 * - This includes order confirmations, stock alerts, etc.
 * *******************************************************
 */

@Document(collection = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    /**
     * Unique identifier for the notification
     */
    @Id
    private String id;

    /**
     * Type of notification (e.g., ORDER_CONFIRMATION, STOCK_ALERT)
     * Must be a valid email address or phone number.
     */
    private Type type;

    /**
     * Recipient of the notification (user or admin identifier/email/phone)
     */
    @Pattern(
            regexp = "^(\\+?[0-9]{10,15}|[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$",
            message = "Recipient must be a valid email or phone number"
    )
    private String to;

    /**
     * Notification content/message
     */
    private String message;

    /**
     * Timestamp of when the notification was created and sent.
     * Automatically populated when saved.
     */
    @CreatedDate
    private LocalDateTime sentAt;

}
