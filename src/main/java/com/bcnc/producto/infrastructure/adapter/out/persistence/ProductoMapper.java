package com.bcnc.producto.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.bcnc.producto.domain.model.Producto;


@Component
public class ProductoMapper {

    public  Producto toDomain(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setIdCadena(entity.getBrandId());
        producto.setFechaInicio(entity.getStartDate());
        producto.setFechaFin(entity.getEndDate());
        producto.setListaPrecio(entity.getPriceList());
        producto.setIdProducto(entity.getProductId());
        producto.setPrioridad(entity.getPriority());
        producto.setPrecio(entity.getPrice());
        producto.setDivisa(entity.getCurrency());

        return producto;
    }

    public  ProductoEntity toEntity(Producto domain) {
        if (domain == null) {
            return null;
        }


        ProductoEntity entity = new ProductoEntity();
        entity.setBrandId(domain.getIdCadena());
            entity.setStartDate(domain.getFechaInicio());
            entity.setEndDate(domain.getFechaFin());
                entity.setPriceList(domain.getListaPrecio());
                entity.setProductId(domain.getIdProducto());
                entity.setPriority(domain.getPrioridad());
                entity.setPrice(domain.getPrecio());
                entity.setCurrency(domain.getDivisa());
                return entity;
    }
}