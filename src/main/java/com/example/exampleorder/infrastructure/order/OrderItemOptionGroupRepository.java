package com.example.exampleorder.infrastructure.order;

import com.example.exampleorder.domain.order.item.OrderItemOptionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemOptionGroupRepository extends JpaRepository<OrderItemOptionGroup, Long> {
}