package com.mart.OnlineMart.controller;

import com.mart.OnlineMart.dao.Customer;
import com.mart.OnlineMart.dto.request.AddAddressRequest;
import com.mart.OnlineMart.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Operation(summary = "Create address",
            description = "Create address for customer")
    @PostMapping("/addAddress")
    public String addAddress(@Valid @RequestBody AddAddressRequest addAddressRequest){
        return addressService.addAddress(addAddressRequest);
    }
}
