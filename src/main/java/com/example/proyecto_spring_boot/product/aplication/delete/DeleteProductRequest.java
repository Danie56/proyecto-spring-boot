package com.example.proyecto_spring_boot.product.aplication.delete;

import com.example.proyecto_spring_boot.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {
    private Long id;
}
