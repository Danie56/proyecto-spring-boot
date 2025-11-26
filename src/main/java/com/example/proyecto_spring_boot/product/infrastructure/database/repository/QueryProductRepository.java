package com.example.proyecto_spring_boot.product.infrastructure.database.repository;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QueryProductRepository extends JpaRepository<ProductEntity,Long>, JpaSpecificationExecutor<ProductEntity> {
    @EntityGraph(attributePaths = {"productDetail", "reviews", "categories"})
    Optional<ProductEntity> findById(Long id);
}
