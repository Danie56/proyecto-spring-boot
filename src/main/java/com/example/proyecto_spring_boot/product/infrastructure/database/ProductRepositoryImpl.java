package com.example.proyecto_spring_boot.product.infrastructure.database;

import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import com.example.proyecto_spring_boot.product.infrastructure.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ArrayList<ProductEntity> products;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public void upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);


        products.add(productEntity);


    }

    @Override
    public Optional<Product> getById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().map(productEntityMapper::mapToProduct);
    }
}
