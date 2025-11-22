package com.example.proyecto_spring_boot.categories.infrastructure.database.repository;

import com.example.proyecto_spring_boot.categories.infrastructure.database.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryCategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
