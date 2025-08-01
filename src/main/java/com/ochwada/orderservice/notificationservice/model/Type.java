package com.ochwada.orderservice.notificationservice.model;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.model
 * File: Type.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 3:23 PM
 * Description: Enum representing the supported notification delivery methods.
 * *******************************************************
 */


public enum Type {
    EMAIL,
    SMS;

    /**
     * Serialize enum as lowercase string (e.g., "email", "sms").
     *
     * @return lowercase representation of the enum constant
     */
    @JsonValue
    public String toLowerCase() {
        return name().toLowerCase();
    }
}
