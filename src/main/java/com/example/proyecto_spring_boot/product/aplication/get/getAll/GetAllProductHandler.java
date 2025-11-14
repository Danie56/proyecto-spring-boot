package com.example.proyecto_spring_boot.product.aplication.get.getAll;

import com.example.proyecto_spring_boot.common.application.mediator.HandlerManage;
import com.example.proyecto_spring_boot.common.domain.PaginationResult;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllProductHandler implements HandlerManage<GetAllProductRequest, GetAllProductResponse> {
    private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {
        PaginationResult<Product> products = productRepository.getAll(request.getQuery());


        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
