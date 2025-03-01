package com.bcnc.product.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bcnc.product.application.exception.ProductNotFoundException;
import com.bcnc.product.application.port.out.ProductRepository;
import com.bcnc.product.domain.model.PriceQuery;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void shouldReturnPriceWhenProductExists() {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        
        PriceQuery expectedPrice = new PriceQuery();
        expectedPrice.setPrice(new BigDecimal("35.50"));
        expectedPrice.setIdProduct(productId);
        expectedPrice.setIdBrand(brandId);
        
        when(productRepository.queryPrice(requestTime, productId, brandId))
            .thenReturn(expectedPrice);

        // When
        PriceQuery result = productService.queryPrice(requestTime, productId, brandId);

        // Then
        assertEquals(expectedPrice.getPrice(), result.getPrice());
        assertEquals(expectedPrice.getIdProduct(), result.getIdProduct());
        assertEquals(expectedPrice.getIdBrand(), result.getIdBrand());
    }

    /*
    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 99999L;
        Integer brandId = 1;
        
        when(productRepository.queryPrice(requestTime, productId, brandId))
            .thenReturn(null);

        // When & Then
        assertThrows(ProductNotFoundException.class, () -> {
            productService.queryPrice(requestTime, productId, brandId);
        });
    }
         */

    @Test
    void shouldHandleMultiplePricesForSameProduct() {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 16, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        
        PriceQuery expectedPrice = new PriceQuery();
        expectedPrice.setPrice(new BigDecimal("25.45"));
        expectedPrice.setIdProduct(productId);
        expectedPrice.setIdBrand(brandId);
        expectedPrice.setPriceList(2);
        
        when(productRepository.queryPrice(requestTime, productId, brandId))
            .thenReturn(expectedPrice);

        // When
        PriceQuery result = productService.queryPrice(requestTime, productId, brandId);

        // Then
        assertEquals(expectedPrice.getPrice(), result.getPrice());
        assertEquals(expectedPrice.getPriceList(), result.getPriceList());
    }
}