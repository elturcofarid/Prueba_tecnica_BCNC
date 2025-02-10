package com.bcnc.producto.producto.domain.repository;

import java.time.LocalDateTime;
import com.bcnc.producto.producto.domain.model.Producto;

public interface IProductoRepository {
    Producto obtenerPrecio(LocalDateTime fecha, Long idProducto, Integer idCadena);

}