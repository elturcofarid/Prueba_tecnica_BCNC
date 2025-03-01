package com.bcnc.product.application.port.out;

import java.time.LocalDateTime;
import com.bcnc.product.domain.model.PriceQuery;

public interface ProductRepository {
    PriceQuery queryPrice(LocalDateTime time, Long productId, Integer brandId);
}