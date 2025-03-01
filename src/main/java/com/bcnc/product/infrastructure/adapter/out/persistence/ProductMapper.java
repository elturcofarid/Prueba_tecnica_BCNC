package com.bcnc.product.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.bcnc.product.domain.model.Product;


@Component
public class ProductMapper {

    public  Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        Product producto = new Product();
        producto.setIdBrand(entity.getBrandId());
        producto.setStartDate(entity.getStartDate());
        producto.setEndDate(entity.getEndDate());
        producto.setPriceList(entity.getPriceList());
        producto.setIdProduct(entity.getProductId());
        producto.setPriority(entity.getPriority());
        producto.setPrice(entity.getPrice());
        producto.setCurr(entity.getCurrency());

        return producto;
    }

    public  ProductEntity toEntity(Product domain) {
        if (domain == null) {
            return null;
        }


        ProductEntity entity = new ProductEntity();
        entity.setBrandId(domain.getIdBrand());
            entity.setStartDate(domain.getStartDate());
            entity.setEndDate(domain.getEndDate());
                entity.setPriceList(domain.getPriceList());
                entity.setProductId(domain.getIdProduct());
                entity.setPriority(domain.getPriority());
                entity.setPrice(domain.getPrice());
                entity.setCurrency(domain.getCurr());
                return entity;
    }
}