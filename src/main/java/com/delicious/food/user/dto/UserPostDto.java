package com.delicious.food.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPostDto {

    private String name;

    private String email;

    private String phone;

    private String facebookId;

    private String billingInfo;

    private String location;
}
