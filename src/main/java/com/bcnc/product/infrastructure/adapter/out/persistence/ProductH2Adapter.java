package com.bcnc.product.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.bcnc.product.application.exception.ProductNotFoundException;
import com.bcnc.product.application.port.out.ProductRepository;
import com.bcnc.product.domain.model.PriceQuery;

@Component
public class ProductH2Adapter implements ProductRepository {
    
    private final ProductH2Repository repository;
    private final ProductMapper mapper;

    public ProductH2Adapter(ProductH2Repository repository, ProductMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public PriceQuery queryPrice(LocalDateTime time, Long idProduct, Integer idBrand) {
        var products = repository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            idProduct, 
            idBrand, 
            time,    
            time    
        );
        
        if (products.isEmpty()) {
            throw new ProductNotFoundException(
                String.format("No price found for product %d and brand %d at time %s", 
                    idProduct, idBrand, time)
            );
        }
        
        return mapper.toDomain(products.get(0));
    }
}