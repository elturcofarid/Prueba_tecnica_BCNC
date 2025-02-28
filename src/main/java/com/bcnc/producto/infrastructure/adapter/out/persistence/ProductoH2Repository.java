package com.bcnc.producto.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoH2Repository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
        Long productId, 
        int brandId, 
        LocalDateTime startDateParam, 
        LocalDateTime endDateParam
    );

}