package com.duchung.transaction_demo.service.impl;

import com.duchung.transaction_demo.dto.OrderResponse;
import com.duchung.transaction_demo.dto.OrderRequest;
import com.duchung.transaction_demo.entity.Order;
import com.duchung.transaction_demo.entity.Payment;
import com.duchung.transaction_demo.exception.PaymentException;
import com.duchung.transaction_demo.repository.OrderRepository;
import com.duchung.transaction_demo.repository.PaymentRepository;
import com.duchung.transaction_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
