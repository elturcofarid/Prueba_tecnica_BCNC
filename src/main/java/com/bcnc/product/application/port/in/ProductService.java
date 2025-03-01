package com.bcnc.producto.application.port.in;

import java.time.LocalDateTime;
import com.bcnc.producto.domain.model.Product;

public interface ProductService {
    Product queryPrice(LocalDateTime time, Long productId, Integer brandId);
}