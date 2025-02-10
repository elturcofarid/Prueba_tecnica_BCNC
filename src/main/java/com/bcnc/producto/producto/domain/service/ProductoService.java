package com.bcnc.producto.producto.domain.service;

import org.springframework.stereotype.Service;
import com.bcnc.producto.producto.domain.model.Producto;
import com.bcnc.producto.producto.domain.repository.IProductoRepository;
import java.time.LocalDateTime;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto obtenerPrecio(LocalDateTime fecha, Long idProducto, Integer idCadena) {
        return productoRepository.obtenerPrecio(fecha, idProducto, idCadena);
    }
}
