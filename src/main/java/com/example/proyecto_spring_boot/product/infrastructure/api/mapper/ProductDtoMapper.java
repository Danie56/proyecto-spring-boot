package com.example.proyecto_spring_boot.product.infrastructure.api.mapper;

import com.example.proyecto_spring_boot.product.aplication.create.CreatePorductRequest;
import com.example.proyecto_spring_boot.product.aplication.update.UpdateProductRequest;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)

public interface ProductDtoMapper {
    CreatePorductRequest mapToProductCreateRequest(ProductDto productDto);

    UpdateProductRequest mapToProductUpdateRequest(ProductDto productDto);


    ProductDto mapToProductDto(Product product);

    Product mapToProduct(ProductDto productDto);


}
