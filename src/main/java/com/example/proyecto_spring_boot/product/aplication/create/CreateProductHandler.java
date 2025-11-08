package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreateProductHandler implements HandlerManage<CreatePorductRequest, Void> {
    private final ProductRepository productRepository;


    @Override
    public Void handle(CreatePorductRequest request) {
        Long id = (long) productRepository.getAll().size() + 1;
        Product product = Product.builder()
                .id(id)
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
