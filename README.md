# 🔔 MicroInventorySystem - Notification

---
###  [Micro Inventory System 🍀 Overview Repository ](https://github.com/Ochwada/MicroInventorySystem-Product)
For the Microservices ⬇️
#### 🔗 [Microservice 1: Product Service](https://github.com/Ochwada/MicroInventorySystem-Product)
#### 🔗 [Microservice 2: Inventory Service](https://github.com/Ochwada/MicroInventorySystem-Inventory)
#### 🔗 [Microservice 3: Order Service](https://github.com/Ochwada/MicroInventorySystem-Order)
#### 🔗 [Microservice 4: Notification Service](https://github.com/Ochwada/MicroInventorySystem-Notification)

---

## Microservice 4: Notification Service - Overview

A supportive component of the microservices-based Inventory Management System that listens for key application 
events—such as successful order placements or low inventory alerts—and delivers notifications to end-users or 
administrators. While actual delivery mechanisms like email or SMS are simulated through console log output, 
the service is designed to be easily extended for real-world messaging integrations. It improves user awareness and 
system transparency by ensuring timely alerts for critical operations.

## Responsibilities
- Accepts `POST` requests to trigger notifications 
- Handles multiple notification types (e.g., `EMAIL`, `SMS`)
- Logs all notifications to the console for simulation 
- Optionally saves notification records to MongoDB Atlas 
- Fully Dockerized and connected to other services via `micro-net`

## API Endpoint
```bash
POST /api/notifications
```

Sample Request Body

```json
{
  "type": "ORDER_CONFIRMATION",
  "to": "user@example.com",
  "message": "Your order #123 has been placed successfully!"
}
```