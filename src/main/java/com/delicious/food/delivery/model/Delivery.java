package com.delicious.food.delivery.model;

import com.delicious.food.order.model.Order;
import com.delicious.food.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_delivery")
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    @ManyToOne
    private User deliveryMan;

    private String status; // Out for Delivery, Delivered
}
