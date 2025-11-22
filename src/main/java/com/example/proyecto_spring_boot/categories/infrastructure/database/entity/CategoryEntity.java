package com.example.proyecto_spring_boot.categories.infrastructure.database.entity;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products = new ArrayList<>();
}
