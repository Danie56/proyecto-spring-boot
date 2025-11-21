package com.example.proyecto_spring_boot.ProductDetails.infrastructure.api;

import lombok.Data;

@Data
public class ProductDetailDto {
    private String specifications;
    private String warranty;
    private String provider;
}
