package com.example.exampleorder.domain.order.payment;

import com.example.exampleorder.domain.order.Order;
import com.example.exampleorder.domain.order.OrderCommand;

public interface PaymentProcessor {
    void pay(Order order, OrderCommand.PaymentRequest request);
}