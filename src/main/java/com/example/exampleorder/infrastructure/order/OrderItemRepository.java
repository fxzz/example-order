package com.example.exampleorder.infrastructure.order;

import com.example.exampleorder.domain.order.item.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}