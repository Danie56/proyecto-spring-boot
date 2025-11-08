package com.example.proyecto_spring_boot.product.domain.port;

import com.example.proyecto_spring_boot.product.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product upsert(Product product);

    Optional<Product> getById(Long id);

    List<Product> getAll();

    void delete(Long id);


}
