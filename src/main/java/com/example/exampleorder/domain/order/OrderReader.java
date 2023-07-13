package com.example.exampleorder.domain.order;

public interface OrderReader {
    Order getOrder(String orderToken);
}