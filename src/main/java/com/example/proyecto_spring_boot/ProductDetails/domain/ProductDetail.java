package com.example.proyecto_spring_boot.ProductDetails.domain;


import com.example.proyecto_spring_boot.product.domain.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetail {
    private Long id;
    private String specifications;
    private String warranty;
    private String provider;
    private Product product;

}
