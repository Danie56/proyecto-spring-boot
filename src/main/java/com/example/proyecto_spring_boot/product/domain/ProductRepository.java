package com.example.proyecto_spring_boot.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void upsert(Product product);

    Optional<Product> getById(Long id);

    List<Product> getAll();

    void delete(Long id);


}
