package com.mart.OnlineMart.dto.request;

import com.mart.OnlineMart.dao.Customer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddAddressRequest {
    @NotNull(message = "customer id required")
    private Long customerId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    @NotNull(message = "state information required")
    private String state;
    @NotNull(message = "country information required")
    private String country;
    @NotNull(message = "postal code required")
    private String postalCode;
    private String landmark;
}
