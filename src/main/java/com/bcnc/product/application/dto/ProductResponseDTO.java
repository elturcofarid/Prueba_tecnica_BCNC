package  com.bcnc.product.application.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponseDTO {
    private BigDecimal price;
    private Long productId;
    private Integer brandId;
    private Integer priceList;
    private String dateAplication;
}