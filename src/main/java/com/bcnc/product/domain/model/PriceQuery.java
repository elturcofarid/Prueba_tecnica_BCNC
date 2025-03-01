package com.bcnc.product.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PriceQuery{
    private Integer idBrand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long idProduct;
    private Integer priority;
    private BigDecimal price;
    private String curr;
    
}


