package com.example.proyecto_spring_boot.product.aplication.update;

import com.example.proyecto_spring_boot.common.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateProductHandler implements HandlerManage<UpdateProductRequest, UpdateProductResponse> {
    private final ProductRepository productRepository;

    @Override
    public UpdateProductResponse handle(UpdateProductRequest request) {
        Long id = 0L;

        if (productRepository.getAll().size() < request.getId()) {

            id = (long) productRepository.getAll().size();
        }
        Product product = productRepository.upsert(Product.builder()
                .id(id + 1)
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .build());
        return new UpdateProductResponse(product);
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
