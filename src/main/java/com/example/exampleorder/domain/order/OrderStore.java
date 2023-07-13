package com.example.exampleorder.domain.order;

import com.example.exampleorder.domain.order.item.OrderItem;
import com.example.exampleorder.domain.order.item.OrderItemOption;
import com.example.exampleorder.domain.order.item.OrderItemOptionGroup;

public interface OrderStore {
    Order store(Order order);
    OrderItem store(OrderItem orderItem);
    OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup);
    OrderItemOption store(OrderItemOption orderItemOption);
}