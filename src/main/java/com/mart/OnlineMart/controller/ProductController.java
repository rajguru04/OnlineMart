package com.mart.OnlineMart.controller;

import com.mart.OnlineMart.dto.request.ProductRequest;
import com.mart.OnlineMart.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/newProduct")
    public String createNewProduct(ProductRequest productRequest){
        return productService.createNewProduct(productRequest);
    }
}
