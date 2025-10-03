# Order Service with Kafka

This project demonstrates **event-driven communication** using **Apache Kafka** with Spring Boot.  
The service publishes and consumes `OrderEvent` messages via the topic `order_topics`.

## 🚀 Features
- **Order Producer** → sends events to Kafka  
- **Order Consumer** → listens for events from Kafka  
- JSON serialization & deserialization with Spring Kafka  
- Runs on Kafka **KRaft mode** (no Zookeeper needed)

## 🛠 Tech Stack
- Java 17+  
- Spring Boot  
- Apache Kafka (KRaft mode)

## ⚙️ Run Locally
1. **Start Kafka (KRaft mode):**
   ```bash
   kafka-server-start.sh config/kraft/server.properties
   ```

2. **Clone the repository:**
   ```bash
   git clone https://github.com/Ravisukhwal76/kafka-implementation.git
   cd kafka-implementation
   ```

3. **Run the service:**
   ```bash
   mvn spring-boot:run
   ```

## 📡 Kafka CLI (for testing)
1. **Produce messages:**
   ```bash
   kafka-console-producer.sh --broker-list localhost:9092 --topic order_topics
   ```

2. **Consume messages:**
   ```bash
   kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic order_topics --from-beginning
   ```

## 📦 Sample OrderEvent JSON
```json
{
  "orderId": "12345",
  "productId": "98765",
  "quantity": 2,
  "price": 500,
  "status": "CREATED"
}
```
