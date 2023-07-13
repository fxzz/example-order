package com.example.exampleorder.infrastructure.order.payment;

import com.example.exampleorder.domain.order.OrderCommand;
import com.example.exampleorder.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
    boolean support(PayMethod payMethod);
    void pay(OrderCommand.PaymentRequest request);
}