package com.delicious.food.user.service;

import com.delicious.food.user.dto.UserGetDto;
import com.delicious.food.user.dto.UserPostDto;
import com.delicious.food.user.model.User;
import com.delicious.food.user.respository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserGetDto registerUser(UserPostDto userPostDto) {
        User user = new User();
        BeanUtils.copyProperties(userPostDto, user);

        user = userRepository.save(user);

        UserGetDto userGetDto = new UserGetDto();
        BeanUtils.copyProperties(user, userGetDto);

        return userGetDto;
    }

    public User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("User not found with id: %d", userId)));
    }

    public UserGetDto setFavoriteCategories(List<String> categories, Long userId){
        User user = findUserById(userId);
        user.setFavoriteCategories(categories);
        userRepository.save(user);
        UserGetDto userGetDto = new UserGetDto();
        BeanUtils.copyProperties(user, userGetDto);
        return userGetDto;
    }
}
