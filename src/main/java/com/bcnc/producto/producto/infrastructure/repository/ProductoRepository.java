package com.bcnc.producto.producto.infrastructure.repository;

import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import com.bcnc.producto.producto.domain.model.Producto;
import com.bcnc.producto.producto.domain.repository.IProductoRepository;
import com.bcnc.producto.producto.infrastructure.mapper.ProductoMapper;
import com.bcnc.producto.producto.infrastructure.persistence.ProductoEntity;

@Repository
public class ProductoRepository implements IProductoRepository {
    
    private final H2ProductoRepository repository;

    public ProductoRepository(H2ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Producto obtenerPrecio(LocalDateTime fecha, Long idProducto, Integer idCadena) {

        ProductoEntity prod = repository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            idProducto, 
            idCadena, 
            fecha,    
            fecha    
        ).get(0);
        
        return ProductoMapper.toDomain(prod);
    }
}