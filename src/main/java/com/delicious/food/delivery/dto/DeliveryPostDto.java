package com.delicious.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryPostDto {

    private Long orderId;

    private Long deliveryManId;

    private String status;
}
