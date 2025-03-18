package com.delicious.food.order.model;

import com.delicious.food.order.enums.OrderStatus;
import com.delicious.food.restaurant.model.Restaurant;
import com.delicious.food.user.model.DeliveryMan;
import com.delicious.food.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "delivery_man_id")
    private DeliveryMan deliveryMan;

    @ElementCollection
    private List<Long> foodItemIds;

    private int quantity;
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
