package com.example.proyecto_spring_boot.product.aplication.delete;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteProductHandler implements HandlerManage<DeleteProductRequest, Void> {
    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {
        Product product = productRepository.getById(request.getId()).orElseThrow(() -> new RuntimeException("product not found"));
        productRepository.delete(request.getId());
        return null;


    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {
        return DeleteProductRequest.class;
    }
}
