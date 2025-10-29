package com.example.proyecto_spring_boot.product.infrastructure.api.mapper;

import com.example.proyecto_spring_boot.product.aplication.create.ProductCreateRequest;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)

public interface ProductMapper {
    ProductCreateRequest mapToProductCreateRequest(ProductCreateDto productDto);

}
