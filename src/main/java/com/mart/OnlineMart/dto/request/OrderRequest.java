package com.mart.OnlineMart.dto.request;

import com.mart.OnlineMart.dao.Customer;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long customerId;
    private List<OrderItemRequest> items;
    private Long shippingAddressId;
    private String paymentMethod;
    private String couponCode;
}
