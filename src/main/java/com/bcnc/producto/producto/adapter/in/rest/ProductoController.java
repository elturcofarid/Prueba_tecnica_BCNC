package com.bcnc.producto.producto.adapter.in.rest;

import org.springframework.web.bind.annotation.*;
import com.bcnc.producto.producto.domain.model.Producto;
import com.bcnc.producto.producto.domain.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/producto/precio")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> obtenerPrecio(
        @RequestParam String fecha,
        @RequestParam Long idProducto,
        @RequestParam Integer idCadena) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm");
            LocalDateTime fechaDateTime = LocalDateTime.parse(fecha, formatter);
            System.out.println(fechaDateTime);

        try {
            Producto producto = productoService.obtenerPrecio(fechaDateTime,idProducto,idCadena);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
