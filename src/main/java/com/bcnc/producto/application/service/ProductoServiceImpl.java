package com.bcnc.producto.application.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.bcnc.producto.application.port.in.ProductoService;
import com.bcnc.producto.application.port.out.ProductRepository;
import com.bcnc.producto.domain.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    private final ProductRepository productRepository;

    public ProductoServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Producto obtenerPrecio(LocalDateTime fecha, Long productId, Integer brandId) {
        return productRepository.loadPrecio(fecha, productId, brandId);
    }
}