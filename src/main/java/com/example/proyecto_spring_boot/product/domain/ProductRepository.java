package com.example.proyecto_spring_boot.product.domain;

public interface ProductRepository {
    void upsert(Product product);
}
