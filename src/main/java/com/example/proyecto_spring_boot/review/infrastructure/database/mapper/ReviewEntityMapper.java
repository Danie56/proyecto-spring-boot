package com.example.proyecto_spring_boot.review.infrastructure.database.mapper;

import com.example.proyecto_spring_boot.review.domain.Review;
import com.example.proyecto_spring_boot.review.infrastructure.database.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReviewEntityMapper {
    @Mapping(target = "product", ignore = true)
    Review mapToReview(ReviewEntity reviewEntity);
}
