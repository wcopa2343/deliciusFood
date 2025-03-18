package com.delicious.food.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserGetDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String facebookId;

    private String billingInfo;

    private String location;

    private List<String> favoriteCategories;
}
