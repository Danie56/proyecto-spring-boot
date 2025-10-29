package com.example.proyecto_spring_boot.product.infrastructure.api.dto;

import lombok.Data;

@Data
public class ProductCreateDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
