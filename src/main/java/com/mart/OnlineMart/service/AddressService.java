package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.Address;
import com.mart.OnlineMart.dao.Customer;
import com.mart.OnlineMart.dto.request.AddAddressRequest;
import com.mart.OnlineMart.repository.AddressRepository;
import com.mart.OnlineMart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    public AddressService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    public String addAddress(AddAddressRequest addAddressRequest){
        Address address = new Address();
        Optional<Customer> customer = customerRepository.findById(addAddressRequest.getCustomerId());
        if(customer.isEmpty()){
            return "Customer not found, address can't be added";
        }
        address.setCustomer(customer.get());
        address.setAddressLine1(addAddressRequest.getAddressLine1());
        address.setAddressLine2(addAddressRequest.getAddressLine2());
        address.setCity(addAddressRequest.getCity());
        address.setCountry(addAddressRequest.getCountry());
        address.setLandmark(addAddressRequest.getLandmark());
        address.setState(addAddressRequest.getState());
        address.setPostalCode(addAddressRequest.getPostalCode());
        addressRepository.save(address);
        return "Address save successfully for customer "+customer.get().getFirstName()+" .";
    }
}
