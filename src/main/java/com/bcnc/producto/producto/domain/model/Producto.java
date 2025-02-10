package com.bcnc.producto.producto.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Producto{
    private Integer idCadena;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Integer listaPrecio;
    private Long idProducto;
    private Integer prioridad;
    private BigDecimal precio;
    private String divisa;

    public Producto() {
    }

    public Integer getIdCadena() {
        return idCadena;
    }

    public void setIdCadena(Integer idCadena) {
        this.idCadena = idCadena;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(Integer listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    

    
}


