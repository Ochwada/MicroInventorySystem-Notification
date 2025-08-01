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
 * File: InventoryClient.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 4:03 PM
 * Description: REST client to communicate with Inventory-Service.
 * Objective: Should verify stock size.
 * *******************************************************
 */

@Component
@RequiredArgsConstructor
public class InventoryClient {
    /**==========================================================
     * Stock verification:
     * 1. Admin
     * * - Stock too low
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
     * The base URL of the inventory service.
     * Injected from the application configuration using the property {@code inventory.service.port}.
     * Used for making HTTP requests to the inventory microservice.
     */
    @Value("${inventory.service.url}")
    private String inventoryServiceUrl;

    @Value("${low.stock.email}")
    private String lowStockEmail;

    /**
     * The service for sending notification requests.
     */
    private final NotificationService service;

    /**
     * Checks the stock quantity for a given product ID by calling the Inventory Service.
     * If the quantity is less than 5, it sends a low stock notification to the admin.
     *
     * @param productId the ID of the product to check
     * @return a message indicating stock status
     */
    public String stockAlert(Long productId) {

        // Retrieve available quantity from the Inventory Service
        Integer quantity = restTemplate.getForObject(
                inventoryServiceUrl + "/" + productId,
                Integer.class
        );

        // Handle null response
        if (quantity == null) {
            return "Unable to retrieve stock for Product ID: " + productId;
        }

        // Notify admin if stock is low
        if (quantity <= 5) {
            NotificationRequest request = new NotificationRequest(
                    NotificationRequest.Type.EMAIL,
                    lowStockEmail,
                    "⚠️ Product ID " + productId + " has low stock (" + quantity + "). Please refill."
            );
            service.send(request);

            return "⚠️ Admin notified for low stock of Product ID: " + productId;

        }

        // Stock is sufficient
        return "✅ Stock for Product ID " + productId + " is sufficient (" + quantity + ")";
    }

}
