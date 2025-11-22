package com.example.proyecto_spring_boot.categories.domain.port;

import com.example.proyecto_spring_boot.categories.domain.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getByIds(List<Long> ids);
}
