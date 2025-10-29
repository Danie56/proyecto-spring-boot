package com.example.proyecto_spring_boot.product.aplication.get.getAll;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllProductHandler implements HandlerManage<GetAllProductRequest, GetAllProductResponse> {
    private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {
        List<Product> products = productRepository.getAll();


        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}
