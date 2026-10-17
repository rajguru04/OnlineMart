package com.mart.OnlineMart.repository;

import com.mart.OnlineMart.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
