package com.bcnc.producto.producto.adapter.in.rest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.bcnc.producto.producto.domain.model.Producto;
import com.bcnc.producto.producto.domain.service.IProductoService;

public class ProductoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private static final Long PRODUCT_ID = 35455L;
    private static final Integer BRAND_ID = 1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();
    }

    @Test
    void test1_DeberiaRetornarProducto_14Junio_10AM() throws Exception {
        // Arrange
        String fecha = "2020-06-14-10.00";
        Producto productoMock = new Producto();
        productoMock.setPrecio(new BigDecimal(35.50));
        when(productoService.obtenerPrecio(any(LocalDateTime.class), eq(PRODUCT_ID), eq(BRAND_ID)))
            .thenReturn(productoMock);

        // Act & Assert
        mockMvc.perform(get("/api/producto/precio")
                .param("fecha", fecha)
                .param("idProducto", PRODUCT_ID.toString())
                .param("idCadena", BRAND_ID.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(35.50));
    }

    @Test
    void test2_DeberiaRetornarProducto_14Junio_16PM() throws Exception {
        // Arrange
        String fecha = "2020-06-14-16.00";
        Producto productoMock = new Producto();
        productoMock.setPrecio(new BigDecimal(25.45));
        when(productoService.obtenerPrecio(any(LocalDateTime.class), eq(PRODUCT_ID), eq(BRAND_ID)))
            .thenReturn(productoMock);

        // Act & Assert
        mockMvc.perform(get("/api/producto/precio")
                .param("fecha", fecha)
                .param("idProducto", PRODUCT_ID.toString())
                .param("idCadena", BRAND_ID.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(25.45));
    }

    @Test
    void test3_DeberiaRetornarProducto_14Junio_21PM() throws Exception {
        // Arrange
        String fecha = "2020-06-14-21.00";
        Producto productoMock = new Producto();
        productoMock.setPrecio(new BigDecimal(35.50));
        when(productoService.obtenerPrecio(any(LocalDateTime.class), eq(PRODUCT_ID), eq(BRAND_ID)))
            .thenReturn(productoMock);

        // Act & Assert
        mockMvc.perform(get("/api/producto/precio")
                .param("fecha", fecha)
                .param("idProducto", PRODUCT_ID.toString())
                .param("idCadena", BRAND_ID.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(35.50));
    }

    @Test
    void test4_DeberiaRetornarProducto_15Junio_10AM() throws Exception {
        // Arrange
        String fecha = "2020-06-15-10.00";
        Producto productoMock = new Producto();
        productoMock.setPrecio(new BigDecimal(30.50));
        when(productoService.obtenerPrecio(any(LocalDateTime.class), eq(PRODUCT_ID), eq(BRAND_ID)))
            .thenReturn(productoMock);

        // Act & Assert
        mockMvc.perform(get("/api/producto/precio")
                .param("fecha", fecha)
                .param("idProducto", PRODUCT_ID.toString())
                .param("idCadena", BRAND_ID.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(30.50));
    }

    @Test
    void test5_DeberiaRetornarProducto_16Junio_21PM() throws Exception {
        // Arrange
        String fecha = "2020-06-16-21.00";
        Producto productoMock = new Producto();
        productoMock.setPrecio(new BigDecimal(38.95));
        when(productoService.obtenerPrecio(any(LocalDateTime.class), eq(PRODUCT_ID), eq(BRAND_ID)))
            .thenReturn(productoMock);

        // Act & Assert
        mockMvc.perform(get("/api/producto/precio")
                .param("fecha", fecha)
                .param("idProducto", PRODUCT_ID.toString())
                .param("idCadena", BRAND_ID.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(38.95));
    }
    }

