package com.example.proyecto_spring_boot.product.infrastructure.database;

import com.example.proyecto_spring_boot.common.domain.PaginationQuery;
import com.example.proyecto_spring_boot.common.domain.PaginationResult;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import com.example.proyecto_spring_boot.product.infrastructure.database.mapper.ProductEntityMapper;
import com.example.proyecto_spring_boot.product.infrastructure.repository.QueryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductEntityMapper productEntityMapper;
    private final QueryProductRepository repository;

    @Override
    public Product upsert(Product product) {
        ProductEntity productEntity = productEntityMapper.mapToProductEntity(product);
        ProductEntity save = repository.save(productEntity);
        return productEntityMapper.mapToProduct(save);

    }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.findById(id).map(productEntityMapper::mapToProduct);
    }

    @Override
    public PaginationResult<Product> getAll(PaginationQuery query) {

        PageRequest pageRequest =  PageRequest.of(query.getPageNumber(), query.getPageSize());
        Page<ProductEntity> pages = repository.findAll(pageRequest);
        return new PaginationResult<Product>(pages.getContent().stream().map(productEntityMapper::mapToProduct).toList(),
                pages.getSize(),
                pages.getTotalPages(),
                pages.getNumber()
            );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
