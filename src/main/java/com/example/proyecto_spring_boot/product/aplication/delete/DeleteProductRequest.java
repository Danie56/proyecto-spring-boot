package com.example.proyecto_spring_boot.product.aplication.delete;

import com.example.proyecto_spring_boot.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {
    private Long id;
}
