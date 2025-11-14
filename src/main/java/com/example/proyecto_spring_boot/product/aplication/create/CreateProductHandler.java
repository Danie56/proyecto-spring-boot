package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.common.application.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateProductHandler implements HandlerManage<CreatePorductRequest, CreateProductResponse> {
    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse handle(CreatePorductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();
        Product save= productRepository.upsert(product);
        return new CreateProductResponse(save);
    }

    @Override
    public Class<CreatePorductRequest> getRequestType() {
        return CreatePorductRequest.class;
    }
}
