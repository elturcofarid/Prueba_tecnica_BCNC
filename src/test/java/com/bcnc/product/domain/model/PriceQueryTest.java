package com.bcnc.product.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PriceQueryTest {

    @Test
    void shouldCreatePriceQueryWithAllFields() {
        // Given
        PriceQuery priceQuery = new PriceQuery();
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = startDate.plusHours(1);

        // When
        priceQuery.setIdBrand(1);
        priceQuery.setStartDate(startDate);
        priceQuery.setEndDate(endDate);
        priceQuery.setPriceList(1);
        priceQuery.setIdProduct(35455L);
        priceQuery.setPriority(1);
        priceQuery.setPrice(new BigDecimal("35.50"));
        priceQuery.setCurr("EUR");

        // Then
        assertEquals(1, priceQuery.getIdBrand());
        assertEquals(startDate, priceQuery.getStartDate());
        assertEquals(endDate, priceQuery.getEndDate());
        assertEquals(1, priceQuery.getPriceList());
        assertEquals(35455L, priceQuery.getIdProduct());
        assertEquals(1, priceQuery.getPriority());
        assertEquals(new BigDecimal("35.50"), priceQuery.getPrice());
        assertEquals("EUR", priceQuery.getCurr());
    }

    @Test
    void shouldHandleNullValues() {
        // Given
        PriceQuery priceQuery = new PriceQuery();

        // When & Then
        assertNotNull(priceQuery);
        assertEquals(null, priceQuery.getIdBrand());
        assertEquals(null, priceQuery.getStartDate());
        assertEquals(null, priceQuery.getEndDate());
        assertEquals(null, priceQuery.getPriceList());
        assertEquals(null, priceQuery.getIdProduct());
        assertEquals(null, priceQuery.getPriority());
        assertEquals(null, priceQuery.getPrice());
        assertEquals(null, priceQuery.getCurr());
    }

    @Test
    void shouldHandlePriceScaleAndPrecision() {
        // Given
        PriceQuery priceQuery = new PriceQuery();
        BigDecimal price = new BigDecimal("35.50");

        // When
        priceQuery.setPrice(price);

        // Then
        assertEquals(0, price.compareTo(priceQuery.getPrice()));
        assertEquals(2, priceQuery.getPrice().scale());
    }
}