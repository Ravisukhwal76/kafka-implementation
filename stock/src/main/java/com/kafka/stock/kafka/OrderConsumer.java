package com.kafka.stock.kafka;

import com.kafka.e_commerace.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        System.out.printf("order event received %s%n",orderEvent.toString());
        System.out.println(orderEvent.getOrder());
        System.out.println(orderEvent.getOrder().getOrderId());
        System.out.println(orderEvent.getOrder().getPrice());
        System.out.println(orderEvent.getOrder().getQty());
        System.out.println(orderEvent.getOrder().getOrderName());
    }
}
