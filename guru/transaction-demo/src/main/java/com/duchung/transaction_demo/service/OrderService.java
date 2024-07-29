package com.duchung.transaction_demo.service;

import com.duchung.transaction_demo.dto.OrderResponse;
import com.duchung.transaction_demo.dto.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
