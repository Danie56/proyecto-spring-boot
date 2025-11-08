package com.example.proyecto_spring_boot.product.aplication.get.getById;

import com.example.proyecto_spring_boot.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetProductByIdResponse {
    private Product product;
}

