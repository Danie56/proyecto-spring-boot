package com.example.proyecto_spring_boot.product.infrastructure;

import com.example.proyecto_spring_boot.product.domain.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    public List<Product> products;

    public ProductController() {
        this.products = List.of(
                Product.builder().id(1L).name("Product 1").description("Description 1").price(111.0).image("imagen 1").build(),
                Product.builder().id(2L).name("Product 2").description("Description 2").price(111.0).image("imagen 2").build());
    }
}
