package com.example.proyecto_spring_boot.IT;

import com.example.proyecto_spring_boot.ProductDetails.infrastructure.api.ProductDetailDto;
import com.example.proyecto_spring_boot.product.domain.execptions.ProductNotFoundException;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.CreateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.UpdateProductDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class ProductIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;
    @Test
    @Sql(value = "/IT/product/data.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/IT/clear.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void findById(){
        ResponseEntity<ProductDto> request = restTemplate.getForEntity("/api/v1/products/1",ProductDto.class);
        assertEquals(HttpStatus.OK, request.getStatusCode());
        Assertions.assertNotNull(request.getBody());
        assertEquals(1L,request.getBody().getId());

    }
    @Test
    @Sql(value = "/IT/clear.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void createProduct(){
        CreateProductDto body = new CreateProductDto(
                "Gaming Laptop",
                "High-performance gaming laptop with RTX 4070 and 16GB RAM",
                1499.99,
                "https://example.com/images/laptop.png",
                new ProductDetailDto("Intel i7, RTX 4070, 16GB RAM, 1TB SSD","One years","sony"),
                List.of(1L, 2L, 3L)
        );
        ResponseEntity<ProductDto> request = restTemplate.postForEntity("/api/v1/products",body, ProductDto.class);

        assertEquals(HttpStatus.OK,request.getStatusCode());
        assertNotNull(request.getBody());

    }
    @Test
    @Sql(value = "/IT/product/data.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/IT/clear.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void updateProduct(){
        UpdateProductDto body = new UpdateProductDto(
                1L,
                "name update",
                "description update",
                1499.99,
                "update_img.png",
                new ProductDetailDto("new specifications","new warranty","new provider"),
                List.of(2L)

        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UpdateProductDto> request = new HttpEntity<>(body, headers);
        ResponseEntity<ProductDto> response = restTemplate.exchange("/api/v1/products", HttpMethod.PUT,request, ProductDto.class);


        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("name update",response.getBody().getName());
        assertEquals("description update",response.getBody().getDescription());
        assertEquals(1, response.getBody().getCategories().size());
        assertNotNull(request.getBody());

    }
}
