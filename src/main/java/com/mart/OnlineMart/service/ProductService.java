package com.mart.OnlineMart.service;

import com.mart.OnlineMart.dao.Product;
import com.mart.OnlineMart.dto.request.ProductRequest;
import com.mart.OnlineMart.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String createNewProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductModel(productRequest.getProductModel());
        product.setProductPrize(productRequest.getProductPrize());
        productRepository.save(product);
        return "Product saved successfully";
    }
}
