package com.delicious.food.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderPostDto {

    private Long userId;

    private Long restaurantId;

    private String status;
}
