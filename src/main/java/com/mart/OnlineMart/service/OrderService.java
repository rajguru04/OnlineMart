package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.CustomerOrder;
import com.mart.OnlineMart.dto.request.OrderRequest;
import com.mart.OnlineMart.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(OrderRequest orderRequest) {
        /*CustomerOrder customerOrder = new CustomerOrder();
        orderRepository.save();*/
    }
}
