package com.example.proyecto_spring_boot.product.infrastructure.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateProductDto {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 10 integer digits and 2 decimal places")
    private Double price;
    @NotBlank(message = "Image URL is required")
    private String image;
    private ProductDetailDto productDetail;


}
