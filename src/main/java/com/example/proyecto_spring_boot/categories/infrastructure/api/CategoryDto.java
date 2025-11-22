package com.example.proyecto_spring_boot.categories.infrastructure.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {
    private String name;

}
