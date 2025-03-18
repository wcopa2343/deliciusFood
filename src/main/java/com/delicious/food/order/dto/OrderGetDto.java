package com.delicious.food.order.dto;

import com.delicious.food.restaurant.model.Restaurant;
import com.delicious.food.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderGetDto {

    private Long id;

    private User user;

    private Restaurant restaurant;

    private String status;
}
