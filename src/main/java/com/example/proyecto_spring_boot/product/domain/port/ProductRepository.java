package com.example.proyecto_spring_boot.product.domain.port;

import com.example.proyecto_spring_boot.common.domain.PaginationQuery;
import com.example.proyecto_spring_boot.common.domain.PaginationResult;
import com.example.proyecto_spring_boot.product.domain.entity.Product;

public interface ProductRepository {
    Product upsert(Product product);


    Product getById(Long id);

    PaginationResult<Product> getAll(PaginationQuery query);

    void delete(Long id);


}
