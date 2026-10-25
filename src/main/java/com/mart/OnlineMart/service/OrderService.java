package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.*;
import com.mart.OnlineMart.dto.request.OrderItemRequest;
import com.mart.OnlineMart.dto.request.OrderRequest;
import com.mart.OnlineMart.dto.response.OrderResponse;
import com.mart.OnlineMart.enums.OrderStatus;
import com.mart.OnlineMart.repository.AddressRepository;
import com.mart.OnlineMart.repository.CustomerRepository;
import com.mart.OnlineMart.repository.OrderRepository;
import com.mart.OnlineMart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository, AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        CustomerOrder customerOrder = new CustomerOrder();
        Optional<Customer> customer = customerRepository.findById(orderRequest.getCustomerId());
        if (customer.isEmpty()) {
            return new OrderResponse("Create your profile first");
        }
        customerOrder.setCustomer(customer.get());
        Optional<Address> address = addressRepository.findById(orderRequest.getShippingAddressId());
        if (address.isEmpty()) {
            return new OrderResponse("Given Address not available");
        }
        customerOrder.setShippingAddress(address.get());
        customerOrder.setOrderStatus(OrderStatus.CREATED);
        customerOrder.setCouponCode(orderRequest.getCouponCode());
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrize = new BigDecimal(0);
        for (OrderItemRequest item : orderRequest.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCustomerOrder(customerOrder);
            orderItem.setQuantity(item.getQuantity());
            Optional<Product> product = productRepository.findById(item.getProductId());
            if (product.isEmpty()) {
                return new OrderResponse("Product is not available");
            }
            Product prod = product.get();
            orderItem.setProduct(product.get());
            BigDecimal itemTotal = new BigDecimal(item.getQuantity() * prod.getProductPrize());
            orderItem.setTotalPrice(itemTotal);
            orderItem.setUnitPrice(new BigDecimal(prod.getProductPrize()));
            orderItems.add(orderItem);
            totalPrize = totalPrize.add(itemTotal);
        }
        customerOrder.setOrderItems(orderItems);
        customerOrder.setTotalPrize(totalPrize);
        LocalDateTime currentTime = LocalDateTime.now();
        customerOrder.setOrderDate(currentTime);
        customerOrder.setUpdatedDate(currentTime);
        CustomerOrder order = orderRepository.save(customerOrder);
        return new OrderResponse(order.getOrderId(), order.getOrderStatus().name(), order.getTotalPrize(), "Order Created Successfully");
    }
}
