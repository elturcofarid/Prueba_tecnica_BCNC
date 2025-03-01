package com.bcnc.product.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.bcnc.product.application.port.out.ProductRepository;
import com.bcnc.product.domain.model.Product;

@Component
public class ProductH2Adapter implements ProductRepository {
    
    private final ProductH2Repository repository;
    private final ProductMapper mapper;

    public ProductH2Adapter(ProductH2Repository repository, ProductMapper mapper) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Product queryPrice(LocalDateTime time, Long idProduct, Integer idBrand) {

        ProductEntity prod = repository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            idProduct, 
            idBrand, 
            time,    
            time    
        ).get(0);
        
        return mapper.toDomain(prod);
    }
}