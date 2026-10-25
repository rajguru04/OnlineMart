package com.mart.OnlineMart.controller;

import com.mart.OnlineMart.dto.request.OrderRequest;
import com.mart.OnlineMart.dto.response.OrderResponse;
import com.mart.OnlineMart.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(
            summary = "Create a new order",
            description = "Creates an order for customer"
    )
    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody @Valid OrderRequest orderRequest){
        if(orderRequest==null){
            return new OrderResponse("Order is invalid");
        }
        return orderService.createOrder(orderRequest);
    }
}
