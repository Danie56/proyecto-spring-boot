package com.example.proyecto_spring_boot.product.aplication.update;

import com.example.proyecto_spring_boot.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProductResponse {
    private Product product;
}
