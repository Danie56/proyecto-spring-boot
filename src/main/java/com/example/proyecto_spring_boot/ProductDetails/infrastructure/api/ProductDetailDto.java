package com.example.proyecto_spring_boot.ProductDetails.infrastructure.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDetailDto {
    private String specifications;
    private String warranty;
    private String provider;
}
