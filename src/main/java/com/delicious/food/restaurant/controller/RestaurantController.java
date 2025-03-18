package com.delicious.food.restaurant.controller;

import com.delicious.food.restaurant.dto.RestaurantGetDto;
import com.delicious.food.restaurant.dto.RestaurantPostDto;
import com.delicious.food.restaurant.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/register")
    public ResponseEntity<RestaurantGetDto> register(@RequestBody RestaurantPostDto restaurantPostDto) {
        return ResponseEntity.ok(restaurantService.registerRestaurant(restaurantPostDto));
    }

    @GetMapping("/findByCategory/{category}")
    public ResponseEntity<List<RestaurantGetDto>> getRestaurantsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(restaurantService.findRestaurantByCategory(category));
    }
}
