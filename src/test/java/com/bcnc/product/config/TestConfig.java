package com.bcnc.product.config;

import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import com.bcnc.product.application.port.in.ProductService;

@TestConfiguration
public class TestConfig {
    // Eliminar el bean de ProductService ya que usamos @MockBean
}