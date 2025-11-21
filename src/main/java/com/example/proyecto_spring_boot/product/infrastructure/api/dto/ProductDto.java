package com.example.proyecto_spring_boot.product.infrastructure.api.dto;

import com.example.proyecto_spring_boot.review.infrastructure.api.dto.ReviewDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private String provider;
    private List<ReviewDto> reviews;

}
