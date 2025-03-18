package com.delicious.food.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SetCategoryDto {

    private List<String> favoriteCategories;
}
