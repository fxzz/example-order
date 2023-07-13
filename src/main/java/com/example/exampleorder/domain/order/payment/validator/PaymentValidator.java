package com.example.exampleorder.domain.order.payment.validator;

import com.example.exampleorder.domain.order.Order;
import com.example.exampleorder.domain.order.OrderCommand;

public interface PaymentValidator {
    void validate(Order order, OrderCommand.PaymentRequest paymentRequest);
}