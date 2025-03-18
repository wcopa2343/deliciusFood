package com.delicious.food.restaurant.service;

import com.delicious.food.restaurant.dto.RestaurantGetDto;
import com.delicious.food.restaurant.dto.RestaurantPostDto;
import com.delicious.food.restaurant.model.Restaurant;
import com.delicious.food.restaurant.respository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantGetDto registerRestaurant(RestaurantPostDto restaurantPostDto) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantPostDto, restaurant);

        restaurant = restaurantRepository.save(restaurant);

        RestaurantGetDto restaurantGetDto = new RestaurantGetDto();
        BeanUtils.copyProperties(restaurant, restaurantGetDto);

        return restaurantGetDto;
    }

    public List<RestaurantGetDto> findRestaurantByCategory(String category) {
        List<Restaurant> restaurants = restaurantRepository.findByCategory(category);

        return restaurants.stream()
                .map(restaurant -> {
                    RestaurantGetDto dto = new RestaurantGetDto();
                    BeanUtils.copyProperties(restaurant, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
