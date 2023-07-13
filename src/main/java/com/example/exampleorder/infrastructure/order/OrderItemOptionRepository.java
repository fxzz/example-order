package com.example.exampleorder.infrastructure.order;

import com.example.exampleorder.domain.order.item.OrderItemOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption, Long> {
}