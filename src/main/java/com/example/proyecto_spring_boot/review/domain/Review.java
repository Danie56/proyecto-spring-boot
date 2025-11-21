package com.example.proyecto_spring_boot.review.domain;

import com.example.proyecto_spring_boot.product.domain.entity.Product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Review {
    private Long id;
    private String comment;
    private Integer score;
    private Product product;
}
