package com.ochwada.orderservice.notificationservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.orderservice.notificationservice.config
 * File: AppConfig.java
 * Author: Ochwada
 * Date: Friday, 01.Aug.2025, 3:19 PM
 * Description:  Configuration class for application-level beans.
 * Objective:
 * *******************************************************
 */

@Configuration
@EnableMongoAuditing // Enables @CreatedDate for MongoDB
public class AppConfig {

    /**
     * Creates and registers a {@link RestTemplate} bean.
     *
     * @return a new instance of {@code RestTemplate}
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
