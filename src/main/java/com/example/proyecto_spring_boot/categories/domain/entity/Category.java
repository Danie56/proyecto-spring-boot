package com.example.proyecto_spring_boot.categories.domain.entity;

import com.example.proyecto_spring_boot.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Category {
    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();
}
