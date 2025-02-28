package com.bcnc.producto.application.port.in;

import java.time.LocalDateTime;
import com.bcnc.producto.domain.model.Producto;

public interface ProductoService {
    Producto obtenerPrecio(LocalDateTime fecha, Long productId, Integer brandId);
}