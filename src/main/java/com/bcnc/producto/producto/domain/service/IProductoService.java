package com.bcnc.producto.producto.domain.service;

import com.bcnc.producto.producto.domain.model.Producto;
import java.time.LocalDateTime;

public interface IProductoService {

    Producto obtenerPrecio(LocalDateTime fecha, Long idProducto, Integer idCadena);

}
