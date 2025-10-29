package com.example.proyecto_spring_boot.product.aplication.get.getById;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetProductByIdHandler implements HandlerManage<GetProductByIdRequest, GetProductByIdResponse> {
    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        Product product = productRepository.getById(request.getId()).orElseThrow(() -> new RuntimeException("product not found"));

        return new GetProductByIdResponse(product);
    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
