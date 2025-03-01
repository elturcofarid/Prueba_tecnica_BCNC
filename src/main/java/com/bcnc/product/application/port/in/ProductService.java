package com.bcnc.product.application.port.in;

import java.time.LocalDateTime;
import com.bcnc.product.domain.model.PriceQuery;

public interface ProductService {
    PriceQuery queryPrice(LocalDateTime time, Long productId, Integer brandId);
}