package com.delicious.food.order.service;

import com.delicious.food.order.dto.OrderGetDto;
import com.delicious.food.order.dto.OrderPostDto;
import com.delicious.food.order.model.Order;
import com.delicious.food.order.respository.OrderRepository;
import com.delicious.food.restaurant.model.Restaurant;
import com.delicious.food.user.model.User;
import com.delicious.food.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public OrderService(OrderRepository orderRepository,
                        UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public OrderGetDto placeOrder(OrderPostDto orderPostDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderPostDto, order);

        User user = new User();
        user.setId(orderPostDto.getUserId());
        order.setUser(user);

        Restaurant restaurant = new Restaurant();
        restaurant.setId(orderPostDto.getRestaurantId());
        order.setRestaurant(restaurant);

        order = orderRepository.save(order);

        OrderGetDto orderGetDto = new OrderGetDto();
        BeanUtils.copyProperties(order, orderGetDto);

        return orderGetDto;
    }

    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order not found with id: %d", orderId)));
    }
}
