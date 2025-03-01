package com.bcnc.product.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.bcnc.product.domain.model.PriceQuery;


@Component
public class ProductMapper {

    public  PriceQuery toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        PriceQuery product = new PriceQuery();
        product.setIdBrand(entity.getBrandId());
        product.setStartDate(entity.getStartDate());
        product.setEndDate(entity.getEndDate());
        product.setPriceList(entity.getPriceList());
        product.setIdProduct(entity.getProductId());
        product.setPriority(entity.getPriority());
        product.setPrice(entity.getPrice());
        product.setCurr(entity.getCurrency());

        return product;
    }

    public  ProductEntity toEntity(PriceQuery domain) {
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