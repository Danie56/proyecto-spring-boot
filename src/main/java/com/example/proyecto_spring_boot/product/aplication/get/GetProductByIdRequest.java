package com.example.proyecto_spring_boot.product.aplication.get;

import com.example.proyecto_spring_boot.common.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
    private Long id;
}
