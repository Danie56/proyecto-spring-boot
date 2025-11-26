package com.example.proyecto_spring_boot.IT;

import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class ProductIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;
    @Test
    @Sql(value = "/IT/product/data.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/IT/clear",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void findByIdWhenProductFound(){
        ResponseEntity<ProductDto> request = restTemplate.getForEntity("/api/v1/products/1",ProductDto.class);
        assertEquals(HttpStatus.OK, request.getStatusCode());

    }
}
