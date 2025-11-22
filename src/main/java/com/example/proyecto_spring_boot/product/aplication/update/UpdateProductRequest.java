package com.example.proyecto_spring_boot.product.aplication.update;

import com.example.proyecto_spring_boot.ProductDetails.aplication.ProductDetailRequest;
import com.example.proyecto_spring_boot.common.application.mediator.Request;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class UpdateProductRequest implements Request<UpdateProductResponse> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private ProductDetailRequest productDetail;
    private List<Long> categories;

}
