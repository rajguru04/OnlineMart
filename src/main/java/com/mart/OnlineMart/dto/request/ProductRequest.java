package com.mart.OnlineMart.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String productModel;
    private Double productPrize;
}
