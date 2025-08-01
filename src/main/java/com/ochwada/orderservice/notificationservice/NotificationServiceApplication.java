package com.ochwada.orderservice.notificationservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(NotificationServiceApplication.class, args);
    }


    //========================================================================
    // .env Configuration
    //========================================================================
    static {
        // Load environment variables from .env file
        // Ignores file if missing (useful for production environments like Heroku)
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String[] envVar = {
                "PORT",
                "ORDER_SERVICE_URL",
                "INVENTORY_SERVICE_URL",
                "SPRING_DATA_MONGODB_URI",
                "LOW_STOCK_EMAIL"

        };

        for (String key : envVar) {
            String values = dotenv.get(key);

            if (values != null) {
                System.setProperty(key, values); // Makes it accessible via System.getProperty
                System.out.println("✅ " + key + " loaded and set.");
            } else {
                System.out.println("⚠️" + key + " not found in .env file. Skipping System.");
            }
        }
    }
    //========================================================================
}
