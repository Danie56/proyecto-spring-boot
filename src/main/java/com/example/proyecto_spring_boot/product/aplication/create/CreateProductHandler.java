package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateProductHandler implements HandlerManage<CreatePorductRequest, Void> {
    private final ProductRepository productRepository;


    @Override
    public Void handle(CreatePorductRequest request) {
        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build();
        productRepository.upsert(product);
        return null;
    }

    @Override
    public Class<CreatePorductRequest> getRequestType() {
        return CreatePorductRequest.class;
    }
}
