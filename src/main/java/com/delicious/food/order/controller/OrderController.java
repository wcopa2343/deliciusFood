package com.delicious.food.order.controller;

import com.delicious.food.order.dto.OrderGetDto;
import com.delicious.food.order.dto.OrderPostDto;
import com.delicious.food.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderGetDto> placeOrder(@RequestBody OrderPostDto orderPostDto) {
        return ResponseEntity.ok(orderService.placeOrder(orderPostDto));
    }
}
