package com.kafka.email_service;

import com.kafka.e_commerace.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsume {

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        System.out.println(orderEvent);
        System.out.println(orderEvent.getMessage());
        System.out.println(orderEvent.getStatus());
        System.out.println(orderEvent.getOrder().getOrderName());
        System.out.println(orderEvent.getOrder().getOrderName());
    }
}
