package com.example.proyecto_spring_boot.review.infrastructure.api.mapper;

import com.example.proyecto_spring_boot.review.domain.Review;
import com.example.proyecto_spring_boot.review.infrastructure.api.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ReviewDtoMapper {

}
