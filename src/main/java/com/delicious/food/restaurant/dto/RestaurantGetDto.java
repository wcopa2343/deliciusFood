package com.delicious.food.restaurant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantGetDto {

    private Long id;

    private String name;

    private String category;

    private String location;
}
