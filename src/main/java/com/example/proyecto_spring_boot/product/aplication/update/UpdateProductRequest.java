package com.example.proyecto_spring_boot.product.aplication.update;

import com.example.proyecto_spring_boot.common.mediator.Request;
import lombok.*;

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
}
