package com.mart.OnlineMart.controller;

import com.mart.OnlineMart.dao.Customer;
import com.mart.OnlineMart.dto.request.CreateCustomerRequest;
import com.mart.OnlineMart.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/newCustomer")
    public String createCustomer(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        customerService.createCustomer(createCustomerRequest);
        return "Customer created successfully";
    }
}
