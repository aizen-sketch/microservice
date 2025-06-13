package com.example.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OrderService.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
