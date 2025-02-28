package  com.bcnc.producto.application.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductoResponseDTO {
    private BigDecimal precio;
    private Long productId;
    private Integer brandId;
    private Integer priceList;
    private String fechaAplicacion;
}