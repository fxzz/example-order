package com.example.exampleorder.domain.order.payment.validator;

import com.example.exampleorder.common.exception.InvalidParamException;
import com.example.exampleorder.domain.order.Order;
import com.example.exampleorder.domain.order.OrderCommand;
import org.springframework.stereotype.Component;

// 동일한 인터페이스를 구현한 여러 구현체에 @Order 애너테이션을 사용하여 실행 순서를 제어할 수 있습니다.
// @org.springframework.core.annotation.Order(value = 1) 벨류가 낮을수록 우선순위가 높다
@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (!order.calculateTotalAmount().equals(paymentRequest.getAmount()))
            throw new InvalidParamException("주문가격이 불일치합니다");
    }
}