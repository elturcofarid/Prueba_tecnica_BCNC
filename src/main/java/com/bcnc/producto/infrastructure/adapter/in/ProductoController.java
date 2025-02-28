package com.bcnc.producto.infrastructure.adapter.in;

import org.springframework.web.bind.annotation.*;

import com.bcnc.producto.application.dto.ProductoResponseDTO;
import com.bcnc.producto.application.port.in.ProductoService;
import com.bcnc.producto.domain.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/producto/precio")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<ProductoResponseDTO> obtenerPrecio(
        @RequestParam String fecha,
        @RequestParam Long idProducto,
        @RequestParam Integer idCadena) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");
            LocalDateTime fechaDateTime = LocalDateTime.parse(fecha, formatter);
            
            Producto producto = productoService.obtenerPrecio(fechaDateTime, idProducto, idCadena);
            return ResponseEntity.ok(mapToDTO(producto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    private ProductoResponseDTO mapToDTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setPrecio(producto.getPrecio());
        dto.setProductId(producto.getIdProducto());
        dto.setBrandId(producto.getIdCadena());
        dto.setPriceList(producto.getListaPrecio());
        dto.setFechaAplicacion(producto.getFechaFin().toString());
        return dto;
    }
    
}
