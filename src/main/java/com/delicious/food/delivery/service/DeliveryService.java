package com.delicious.food.delivery.service;

import com.delicious.food.delivery.dto.DeliveryGetDto;
import com.delicious.food.delivery.dto.DeliveryPostDto;
import com.delicious.food.delivery.model.Delivery;
import com.delicious.food.delivery.respository.DeliveryRepository;
import com.delicious.food.order.model.Order;
import com.delicious.food.user.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public DeliveryGetDto assignDelivery(DeliveryPostDto deliveryPostDto) {
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(deliveryPostDto, delivery);

        Order order = new Order();
        order.setId(deliveryPostDto.getOrderId());
        delivery.setOrder(order);

        User deliveryMan = new User();
        deliveryMan.setId(deliveryPostDto.getDeliveryManId());
        delivery.setDeliveryMan(deliveryMan);

        delivery = deliveryRepository.save(delivery);

        DeliveryGetDto deliveryGetDto = new DeliveryGetDto();
        BeanUtils.copyProperties(delivery, deliveryGetDto);

        return deliveryGetDto;
    }

}

