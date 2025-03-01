package com.bcnc.product.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.bcnc.product.application.port.out.ProductRepository;
import com.bcnc.product.domain.model.PriceQuery;

class ProductServiceTest {

    @Mock
    private ProductRepository repository;
    
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ProductServiceImpl(repository);
    }

    @Test
    void shouldDelegateToRepository() {
        // Given
        LocalDateTime time = LocalDateTime.now();
        PriceQuery expected = new PriceQuery();
        when(repository.queryPrice(time, 1L, 1)).thenReturn(expected);

        // When
        PriceQuery result = service.queryPrice(time, 1L, 1);

        // Then
        assertEquals(expected, result);
        verify(repository).queryPrice(time, 1L, 1);
    }
}