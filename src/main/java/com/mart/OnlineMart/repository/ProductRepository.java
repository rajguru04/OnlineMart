package com.mart.OnlineMart.repository;

import com.mart.OnlineMart.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
