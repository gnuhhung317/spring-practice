package com.duchung.transaction_demo.dto;

import com.duchung.transaction_demo.entity.Order;
import com.duchung.transaction_demo.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;


}
