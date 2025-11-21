package com.example.proyecto_spring_boot.product.infrastructure.database.mapper;

import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import com.example.proyecto_spring_boot.review.infrastructure.database.mapper.ReviewEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper extends ReviewEntityMapper {
    @Mapping(target = "productDetail.product", ignore = true)
    @Mapping(target = "reviews[].product", ignore = true)
    ProductEntity mapToProductEntity(Product product);
    @Mapping(target = "productDetail.product", ignore = true)
    Product mapToProduct(ProductEntity productEntity);

}
