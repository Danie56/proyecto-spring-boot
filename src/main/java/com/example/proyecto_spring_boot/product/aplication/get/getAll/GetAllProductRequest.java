package com.example.proyecto_spring_boot.product.aplication.get.getAll;

import com.example.proyecto_spring_boot.common.application.mediator.Request;
import com.example.proyecto_spring_boot.common.domain.PaginationQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetAllProductRequest implements Request<GetAllProductResponse> {
    private PaginationQuery query;

}
