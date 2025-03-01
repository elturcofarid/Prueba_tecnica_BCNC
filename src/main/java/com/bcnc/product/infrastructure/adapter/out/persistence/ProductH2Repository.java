package com.bcnc.product.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductH2Repository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
        Long productId, 
        Integer brandId, 
        LocalDateTime startDate,
        LocalDateTime endDate
    );
}