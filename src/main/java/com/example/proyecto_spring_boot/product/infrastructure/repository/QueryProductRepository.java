package com.example.proyecto_spring_boot.product.infrastructure.repository;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryProductRepository extends JpaRepository<ProductEntity,Long>, JpaSpecificationExecutor<ProductEntity> {
}
