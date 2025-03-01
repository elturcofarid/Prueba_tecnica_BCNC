package com.bcnc.product.application.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.bcnc.product.application.port.in.ProductService;
import com.bcnc.product.application.port.out.ProductRepository;
import com.bcnc.product.domain.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product queryPrice(LocalDateTime time, Long productId, Integer brandId) {
        return productRepository.queryPrice(time, productId, brandId);
    }
}