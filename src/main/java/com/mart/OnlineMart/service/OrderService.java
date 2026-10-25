package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.Customer;
import com.mart.OnlineMart.dao.CustomerOrder;
import com.mart.OnlineMart.dao.Product;
import com.mart.OnlineMart.dto.request.OrderRequest;
import com.mart.OnlineMart.dto.response.OrderResponse;
import com.mart.OnlineMart.enums.OrderStatus;
import com.mart.OnlineMart.repository.CustomerRepository;
import com.mart.OnlineMart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        CustomerOrder customerOrder = new CustomerOrder();
        Optional<Customer> customer = customerRepository.findById(orderRequest.getCustomerId());
        if(customer.isEmpty()){
            return new OrderResponse("Create your profile first");
        }
        customerOrder.setCustomer(customer.get());
        customerOrder.setOrderStatus(OrderStatus.CREATED);

        customerOrder.setTotalAmount(new BigDecimal(5446464));
        LocalDateTime currentTime = LocalDateTime.now();
        customerOrder.setOrderDate(currentTime);
        customerOrder.setUpdatedDate(currentTime);
        orderRepository.save(customerOrder);
    }
}
