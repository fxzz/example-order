package com.example.exampleorder.domain.order.payment.validator;

import com.example.exampleorder.common.exception.InvalidParamException;
import com.example.exampleorder.domain.order.Order;
import com.example.exampleorder.domain.order.OrderCommand;
import com.example.exampleorder.domain.order.payment.PayMethod;
import org.springframework.stereotype.Component;

@Component
public class FdsPaymentValidator implements PaymentValidator{

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
       if (paymentRequest.getPayMethod() == PayMethod.해외카드) {
           throw new InvalidParamException();
       }

    }
}
