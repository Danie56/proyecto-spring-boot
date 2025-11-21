package com.example.proyecto_spring_boot.review.infrastructure.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {
    private String comment;
    private Integer score;
}
