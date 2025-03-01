package com.bcnc.producto.infrastructure.adapter.in;

import org.springframework.web.bind.annotation.*;

import com.bcnc.producto.application.dto.ProductResponseDTO;
import com.bcnc.producto.application.port.in.ProductService;
import com.bcnc.producto.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/product/price")
public class PriceQueryController {
    private final ProductService productService;

    public PriceQueryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<ProductResponseDTO> priceQueryResponse(
        @RequestParam String time,
        @RequestParam Long idProduct,
        @RequestParam Integer idBrand) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");
            LocalDateTime localTime = LocalDateTime.parse(time, formatter);
            
            Product product = productService.queryPrice(localTime, idProduct, idBrand);
            return ResponseEntity.ok(mapToDTO(product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    private ProductResponseDTO mapToDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setPrice(product.getPrice());
        dto.setProductId(product.getIdProduct());
        dto.setBrandId(product.getIdBrand());
        dto.setPriceList(product.getPriceList());
        dto.setDateAplication(product.getEndDate().toString());
        return dto;
    }
    
}
