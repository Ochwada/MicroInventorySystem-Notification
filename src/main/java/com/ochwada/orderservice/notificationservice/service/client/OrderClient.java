package com.ochwada.orderservice.notificationservice.service.client;


import com.ochwada.orderservice.notificationservice.dto.request.NotificationRequest;
import com.ochwada.orderservice.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.service.client
 * File: OrderClient.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 5:09 PM
 * Description:  REST client to communicate with Order-Service.
 *  * Sends order confirmation notifications to the user.
 * *******************************************************
 */

@Component
@RequiredArgsConstructor
public class OrderClient {
    /**==========================================================
     * 2. User
     * * - Order Confirmation
     ========================================================== */
    /**
     * The HTTP client used to send requests to external services.
     */
    private final RestTemplate restTemplate;

    /**
     * The service for sending notification requests.
     */
    private final NotificationService notificationService;

    /**
     * The base URL of the order service.
     * Injected from the application configuration using the property {@code order.service.url}.
     */
    @Value("${order.service.url}")
    private String orderServiceUrl;

    /**
     * Sends an order confirmation notification to the user.
     *
     * @param userEmail the user's email address
     * @param orderId   the ID of the order
     * @param isSuccess whether the order was successful
     */
    private  void orderNotification(String userEmail, Long orderId, boolean isSuccess ){

        String message = isSuccess
                ? "✅ Your order #" + orderId + " has been placed successfully!"
                : "⚠\uFE0F Your order #" + orderId + " could not be processed. Please try again.";

        NotificationRequest request = new NotificationRequest(
                NotificationRequest.Type.EMAIL,
                userEmail,
                message
        );

        notificationService.send(request);
    }
}
