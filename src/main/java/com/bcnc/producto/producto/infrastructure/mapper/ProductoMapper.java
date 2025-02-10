package com.bcnc.producto.producto.infrastructure.mapper;

import com.bcnc.producto.producto.domain.model.Producto;
import com.bcnc.producto.producto.infrastructure.persistence.ProductoEntity;

public class ProductoMapper {

    public static Producto toDomain(ProductoEntity entity) {
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

    public static ProductoEntity toEntity(Producto domain) {
        if (domain == null) {
            return null;
        }

        return new ProductoEntity(
            domain.getIdCadena(),
            domain.getFechaInicio(),
            domain.getFechaFin(),
            domain.getListaPrecio(),
            domain.getIdProducto(),
            domain.getPrioridad(),
            domain.getPrecio(),
            domain.getDivisa()
        );
    }
}