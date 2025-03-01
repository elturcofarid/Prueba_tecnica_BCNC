package com.bcnc.producto.application.port.out;

import java.time.LocalDateTime;
import com.bcnc.producto.domain.model.Product;

public interface ProductRepository {
    Product queryPrice(LocalDateTime time, Long productId, Integer brandId);
}