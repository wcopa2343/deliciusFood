package com.delicious.food.user.controller;

import com.delicious.food.user.dto.SetCategoryDto;
import com.delicious.food.user.dto.UserGetDto;
import com.delicious.food.user.dto.UserPostDto;
import com.delicious.food.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserGetDto> register(@RequestBody UserPostDto userPostDto) {
        return ResponseEntity.ok(userService.registerUser(userPostDto));
    }

    @PutMapping("/setCategories/{id}")
    public ResponseEntity<UserGetDto> setCategories(@PathVariable Long id, @RequestBody SetCategoryDto setCategoryDto) {
        return ResponseEntity.ok(
                userService.setFavoriteCategories(setCategoryDto.getFavoriteCategories(),id)
        );
    }
}
