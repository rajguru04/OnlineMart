package com.mart.OnlineMart.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {
    private Long orderId;
    private String orderStatus;
    private BigDecimal totalAmount;
    private String message;

    public OrderResponse(String message){
        this(0L, null, new BigDecimal("0.0"), message);
    }

    public OrderResponse(Long orderId, String status, BigDecimal totalAmount, String message){
        this.orderId=orderId;
        this.orderStatus=status;
        this.totalAmount=totalAmount;
        this.message=message;
    }
}
