package com.delicious.food.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryManGetDto {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String facebookId;

    private String vehicleInfo;
}
