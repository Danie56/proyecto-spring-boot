package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.ProductDetails.aplication.ProductDetailRequest;
import com.example.proyecto_spring_boot.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePorductRequest implements Request<CreateProductResponse> {
    private String name;
    private String description;
    private Double price;
    private String image;
    private ProductDetailRequest productDetail;
    private List<Long> categories;
}
