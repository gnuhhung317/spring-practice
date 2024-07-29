package com.duchung.transaction_demo.controller;

import com.duchung.transaction_demo.dto.OrderResponse;
import com.duchung.transaction_demo.dto.OrderRequest;
import com.duchung.transaction_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest.toString());
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
