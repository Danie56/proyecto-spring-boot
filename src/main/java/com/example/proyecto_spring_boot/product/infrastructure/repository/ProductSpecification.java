package com.example.proyecto_spring_boot.product.infrastructure.repository;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<ProductEntity> byName(String name){

        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"),"%" + name + "%");
    }
    public static Specification<ProductEntity> priceBetween(Double priceMin, Double priceMax){

        return (root, query, criteriaBuilder) ->
                priceMin == null || priceMax == null ? null : criteriaBuilder.between(root.get("price"),priceMin,priceMax);



    }
}
