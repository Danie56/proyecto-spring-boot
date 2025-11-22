package com.example.proyecto_spring_boot.categories.infrastructure.database;

import com.example.proyecto_spring_boot.categories.domain.entity.Category;
import com.example.proyecto_spring_boot.categories.domain.port.CategoryRepository;
import com.example.proyecto_spring_boot.categories.infrastructure.database.mapper.CategoryEntityMapper;
import com.example.proyecto_spring_boot.categories.infrastructure.database.repository.QueryCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final QueryCategoryRepository repository;
    private final CategoryEntityMapper categoryEntityMapper;
    @Override
    public List<Category> getByIds(List<Long> ids) {
        return repository.findAllById(ids).stream().map(categoryEntityMapper::mapToCategory).toList();
    }
}
