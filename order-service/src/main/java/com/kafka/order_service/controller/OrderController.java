package com.kafka.order_service.controller;

import com.kafka.e_commerace.dto.Order;
import com.kafka.e_commerace.dto.OrderEvent;
import com.kafka.order_service.kafka.OrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/order")
    public ResponseEntity<?> placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("pending");
        orderEvent.setMessage("Order in pending status");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return new ResponseEntity<>("Order Placed Successfully !",HttpStatus.OK);
    }
}
