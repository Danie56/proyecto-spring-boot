package com.example.proyecto_spring_boot.product.aplication.get.getById;

import com.example.proyecto_spring_boot.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
    private Long id;
}
