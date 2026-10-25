package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.Address;
import com.mart.OnlineMart.dao.Customer;
import com.mart.OnlineMart.dto.request.CreateCustomerRequest;
import com.mart.OnlineMart.repository.AddressRepository;
import com.mart.OnlineMart.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
    }

    public String createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(createCustomerRequest.getFirstName());
        customer.setLastName(createCustomerRequest.getLastName());
        customer.setPhoneNumber(createCustomerRequest.getPhoneNumber());
        customer.setPasswordHash(createCustomerRequest.getPassword());
        customer.setEmail(createCustomerRequest.getEmail());
        customerRepository.save(customer);
        return "Customer Created Successfully";
    }
}
