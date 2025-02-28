package com.bcnc.producto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Producto{
    private Integer idCadena;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer listaPrecio;
    private Long idProducto;
    private Integer prioridad;
    private BigDecimal precio;
    private String divisa;

}


