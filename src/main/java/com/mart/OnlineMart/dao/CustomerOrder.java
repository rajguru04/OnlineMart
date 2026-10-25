package com.mart.OnlineMart.dao;

import com.mart.OnlineMart.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "addressId",  nullable = false)
    private Address shippingAddress;

    @Column(name="payment_method",nullable = false)
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status",nullable = false, length = 30)
    private OrderStatus orderStatus = OrderStatus.PENDING;

    @Column(name = "total_prize")
    private BigDecimal totalPrize;

    @Column(name = "coupon_code")
    private String couponCode;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
        updatedDate = orderDate;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
