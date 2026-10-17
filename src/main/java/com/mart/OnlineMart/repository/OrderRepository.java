package com.mart.OnlineMart.repository;

import com.mart.OnlineMart.dao.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    //void save();
}
