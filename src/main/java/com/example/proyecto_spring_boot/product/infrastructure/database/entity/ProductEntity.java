package com.example.proyecto_spring_boot.product.infrastructure.database.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductEntity {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
