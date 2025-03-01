package com.bcnc.product.infrastructure.adapter.in;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import com.bcnc.product.application.port.in.ProductService;
import com.bcnc.product.config.TestConfig;
import com.bcnc.product.domain.model.PriceQuery;

@WebMvcTest(controllers = PriceQueryController.class)
@Import(TestConfig.class)
@AutoConfigureMockMvc(addFilters = false)
public class PriceQueryControllerTest {

    @MockBean
    private ProductService productService;  // Usar @MockBean en lugar de @Mock

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnPriceForProduct35455AndBrand1At10AM() throws Exception {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        BigDecimal expectedPrice = new BigDecimal("35.50");

        PriceQuery mockProduct = new PriceQuery();
        mockProduct.setPrice(expectedPrice);
        mockProduct.setIdProduct(productId);
        mockProduct.setIdBrand(brandId);
        mockProduct.setPriceList(1);
        mockProduct.setEndDate(requestTime.plusHours(1));

        when(productService.queryPrice(requestTime, productId, brandId))
            .thenReturn(mockProduct);

        // When & Then
        mockMvc.perform(get("/api/product/price")
                .param("time", "2020-06-14-10.00")
                .param("idProduct", productId.toString())
                .param("idBrand", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId));
    }

    @Test
    public void shouldReturnPriceForProduct35455AndBrand1At16PM() throws Exception {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 16, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        BigDecimal expectedPrice = new BigDecimal("25.45");

        PriceQuery mockProduct = new PriceQuery();
        mockProduct.setPrice(expectedPrice);
        mockProduct.setIdProduct(productId);
        mockProduct.setIdBrand(brandId);
        mockProduct.setPriceList(2);
        mockProduct.setEndDate(requestTime.plusHours(1));

        when(productService.queryPrice(requestTime, productId, brandId))
            .thenReturn(mockProduct);

        // When & Then
        mockMvc.perform(get("/api/product/price")
                .param("time", "2020-06-14-16.00")
                .param("idProduct", productId.toString())
                .param("idBrand", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId));
    }

    @Test
    public void shouldReturnPriceForProduct35455AndBrand1At21PM() throws Exception {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 21, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        BigDecimal expectedPrice = new BigDecimal("35.50");

        PriceQuery mockProduct = new PriceQuery();
        mockProduct.setPrice(expectedPrice);
        mockProduct.setIdProduct(productId);
        mockProduct.setIdBrand(brandId);
        mockProduct.setPriceList(1);
        mockProduct.setEndDate(requestTime.plusHours(1));

        when(productService.queryPrice(requestTime, productId, brandId))
            .thenReturn(mockProduct);

        // When & Then
        mockMvc.perform(get("/api/product/price")
                .param("time", "2020-06-14-21.00")
                .param("idProduct", productId.toString())
                .param("idBrand", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId));
    }

    @Test
    public void shouldReturnPriceForProduct35455AndBrand1At10AM15() throws Exception {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 15, 10, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        BigDecimal expectedPrice = new BigDecimal("30.50");

        PriceQuery mockProduct = new PriceQuery();
        mockProduct.setPrice(expectedPrice);
        mockProduct.setIdProduct(productId);
        mockProduct.setIdBrand(brandId);
        mockProduct.setPriceList(1);
        mockProduct.setEndDate(requestTime.plusHours(1));

        when(productService.queryPrice(requestTime, productId, brandId))
            .thenReturn(mockProduct);

        // When & Then
        mockMvc.perform(get("/api/product/price")
                .param("time", "2020-06-15-10.00")
                .param("idProduct", productId.toString())
                .param("idBrand", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId));
    }

    @Test
    public void shouldReturnPriceForProduct35455AndBrand1At21PM16() throws Exception {
        // Given
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 16, 21, 0);
        Long productId = 35455L;
        Integer brandId = 1;
        BigDecimal expectedPrice = new BigDecimal("38.95");

        PriceQuery mockProduct = new PriceQuery();
        mockProduct.setPrice(expectedPrice);
        mockProduct.setIdProduct(productId);
        mockProduct.setIdBrand(brandId);
        mockProduct.setPriceList(1);
        mockProduct.setEndDate(requestTime.plusHours(1));

        when(productService.queryPrice(requestTime, productId, brandId))
            .thenReturn(mockProduct);

        // When & Then
        mockMvc.perform(get("/api/product/price")
                .param("time", "2020-06-16-21.00")
                .param("idProduct", productId.toString())
                .param("idBrand", brandId.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.productId").value(productId))
                .andExpect(jsonPath("$.brandId").value(brandId));
    }


    

}