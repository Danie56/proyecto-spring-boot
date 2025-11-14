package com.example.proyecto_spring_boot.product.domain.port;

import com.example.proyecto_spring_boot.common.domain.PaginationQuery;
import com.example.proyecto_spring_boot.common.domain.PaginationResult;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product upsert(Product product);

    Optional<Product> getById(Long id);

    PaginationResult<Product> getAll(PaginationQuery query);

    void delete(Long id);


}
