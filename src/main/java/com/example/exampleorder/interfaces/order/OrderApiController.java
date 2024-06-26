package com.example.exampleorder.interfaces.order;

import com.example.exampleorder.application.order.OrderFacade;
import com.example.exampleorder.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderApiController {
    private final OrderFacade orderFacade;
    private final OrderDtoMapper orderDtoMapper;

    @PostMapping("/init")
    public CommonResponse registerOrder(@RequestBody @Valid OrderDto.RegisterOrderRequest request) {
        var orderCommand = orderDtoMapper.of(request);
        var orderToken = orderFacade.registerOrder(orderCommand);
        var response = orderDtoMapper.of(orderToken);
        return CommonResponse.success(response);
    }

    @GetMapping("/{orderToken}")
    public CommonResponse retrieveOrder(@PathVariable String orderToken) {
        var orderResult = orderFacade.retrieveOrder(orderToken);
        var response = orderDtoMapper.of(orderResult);
        return CommonResponse.success(response);
    }

    @PostMapping("/payment-order")
    public CommonResponse paymentOrder(@RequestBody @Valid OrderDto.PaymentRequest paymentRequest) {
        var paymentCommand = orderDtoMapper.of(paymentRequest);
        orderFacade.paymentOrder(paymentCommand);
        return CommonResponse.success("OK");
    }
}