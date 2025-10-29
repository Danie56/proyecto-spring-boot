package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePorductRequest implements Request<Void> {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
