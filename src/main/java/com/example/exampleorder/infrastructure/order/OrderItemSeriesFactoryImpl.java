package com.example.exampleorder.infrastructure.order;

import com.example.exampleorder.domain.item.ItemReader;
import com.example.exampleorder.domain.order.Order;
import com.example.exampleorder.domain.order.OrderCommand;
import com.example.exampleorder.domain.order.OrderItemSeriesFactory;
import com.example.exampleorder.domain.order.OrderStore;
import com.example.exampleorder.domain.order.item.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderItemSeriesFactoryImpl implements OrderItemSeriesFactory {
    private final ItemReader itemReader;
    private final OrderStore orderStore;

    @Override
    public List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder) {
        return requestOrder.getOrderItemList().stream()
                .map(orderItemRequest -> {
                    var item = itemReader.getItemBy(orderItemRequest.getItemToken());
                    var initOrderItem = orderItemRequest.toEntity(order, item);
                    var orderItem = orderStore.store(initOrderItem);

                    orderItemRequest.getOrderItemOptionGroupList().forEach(orderItemOptionGroupRequest -> {
                        var initOrderItemOptionGroup = orderItemOptionGroupRequest.toEntity(orderItem);
                        var orderItemOptionGroup = orderStore.store(initOrderItemOptionGroup);

                        orderItemOptionGroupRequest.getOrderItemOptionList().forEach(orderItemOptionRequest -> {
                            var initOrderItemOption = orderItemOptionRequest.toEntity(orderItemOptionGroup);
                            orderStore.store(initOrderItemOption);
                        });
                    });
                    return orderItem;
                }).collect(Collectors.toList());
    }
}