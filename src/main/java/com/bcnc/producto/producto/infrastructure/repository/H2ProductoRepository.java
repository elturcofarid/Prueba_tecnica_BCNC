package com.bcnc.producto.producto.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.producto.producto.infrastructure.persistence.ProductoEntity;

@Repository
public interface H2ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    List<ProductoEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
        Long productId, 
        int brandId, 
        LocalDateTime startDateParam, 
        LocalDateTime endDateParam
    );

}