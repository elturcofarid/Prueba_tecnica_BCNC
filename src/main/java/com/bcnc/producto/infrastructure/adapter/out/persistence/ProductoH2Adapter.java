package com.bcnc.producto.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.bcnc.producto.application.port.out.ProductRepository;
import com.bcnc.producto.domain.model.Producto;

@Component
public class ProductoH2Adapter implements ProductRepository {
    
    private final ProductoH2Repository repository;
    private final ProductoMapper mapper;

    public ProductoH2Adapter(ProductoH2Repository repository, ProductoMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Producto loadPrecio(LocalDateTime fecha, Long idProducto, Integer idCadena) {

        ProductoEntity prod = repository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            idProducto, 
            idCadena, 
            fecha,    
            fecha    
        ).get(0);
        
        return mapper.toDomain(prod);
    }
}