package com.delicious.food.user.service;

import com.delicious.food.user.dto.DeliveryManGetDto;
import com.delicious.food.user.dto.DeliveryManPostDto;
import com.delicious.food.user.model.DeliveryMan;
import com.delicious.food.user.respository.DeliveryManRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DeliveryManService {

    private final DeliveryManRepository deliveryManRepository;

    public DeliveryManService(DeliveryManRepository deliveryManRepository) {
        this.deliveryManRepository = deliveryManRepository;
    }

    public DeliveryManGetDto save(DeliveryManPostDto deliveryManPostDto) {
        DeliveryMan deliveryMan = new DeliveryMan();
        BeanUtils.copyProperties(deliveryManPostDto, deliveryMan);
        deliveryMan = deliveryManRepository.save(deliveryMan);

        DeliveryManGetDto deliveryManGetDto = new DeliveryManGetDto();
        BeanUtils.copyProperties(deliveryMan, deliveryManGetDto);

        return deliveryManGetDto;
    }

    public DeliveryMan findDeliveryManById(Long id){
        return deliveryManRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("DeliveryMan not found with id: %d", id)));
    }
}
