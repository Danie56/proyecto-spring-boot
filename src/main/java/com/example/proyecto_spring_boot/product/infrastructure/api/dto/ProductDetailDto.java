package com.example.proyecto_spring_boot.product.infrastructure.api.dto;

import lombok.Data;

@Data
public class ProductDetailDto {
    private String specifications;
    private String warranty;
    private String provider;
}
