package com.delicious.food.delivery.dto;

import com.delicious.food.order.model.Order;
import com.delicious.food.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryGetDto {

    private Long id;

    private Order order;

    private User deliveryMan;

    private String status;
}
