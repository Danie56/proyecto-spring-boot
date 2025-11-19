package com.example.proyecto_spring_boot.ProductDetails.aplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRequest {
    private String specifications;
    private String warranty;
    private String provider;
}
