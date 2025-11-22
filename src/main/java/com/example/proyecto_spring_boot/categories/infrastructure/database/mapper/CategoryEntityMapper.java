package com.example.proyecto_spring_boot.categories.infrastructure.database.mapper;

import com.example.proyecto_spring_boot.categories.domain.entity.Category;
import com.example.proyecto_spring_boot.categories.infrastructure.database.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryEntityMapper {
    @Mapping(target = "products", ignore = true)
    Category mapToCategory(CategoryEntity category);

}
