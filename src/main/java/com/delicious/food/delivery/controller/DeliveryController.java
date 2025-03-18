package com.delicious.food.delivery.controller;

import com.delicious.food.delivery.dto.DeliveryGetDto;
import com.delicious.food.delivery.dto.DeliveryPostDto;
import com.delicious.food.delivery.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/assign")
    public ResponseEntity<DeliveryGetDto> assignDelivery(@RequestBody DeliveryPostDto deliveryPostDto) {
        return ResponseEntity.ok(deliveryService.assignDelivery(deliveryPostDto));
    }
}
