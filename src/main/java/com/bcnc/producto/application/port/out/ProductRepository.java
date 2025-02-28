package com.bcnc.producto.application.port.out;

import java.time.LocalDateTime;
import com.bcnc.producto.domain.model.Producto;

public interface ProductRepository {
    Producto loadPrecio(LocalDateTime fecha, Long productId, Integer brandId);
}