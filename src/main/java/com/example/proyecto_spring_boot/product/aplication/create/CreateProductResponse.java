package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
public class CreateProductResponse {
    private Product product;
}
