package com.delicious.food.user.respository;

import com.delicious.food.user.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
}
