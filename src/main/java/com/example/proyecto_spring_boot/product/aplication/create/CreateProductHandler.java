package com.example.proyecto_spring_boot.product.aplication.create;

import com.example.proyecto_spring_boot.ProductDetails.domain.ProductDetail;
import com.example.proyecto_spring_boot.categories.domain.entity.Category;
import com.example.proyecto_spring_boot.categories.domain.port.CategoryRepository;
import com.example.proyecto_spring_boot.common.application.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CreateProductHandler implements HandlerManage<CreatePorductRequest, CreateProductResponse> {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public CreateProductResponse handle(CreatePorductRequest request) {

        List<Category> categories = categoryRepository.getByIds(request.getCategories());
        ProductDetail productDetail = ProductDetail.builder()
                .specifications(request.getProductDetail().getSpecifications())
                .warranty(request.getProductDetail().getWarranty())
                .provider(request.getProductDetail().getProvider())
                .build();
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .productDetail(productDetail)
                .categories(categories)
                .build();

        Product save= productRepository.upsert(product);
        return new CreateProductResponse(save);
    }

    @Override
    public Class<CreatePorductRequest> getRequestType() {
        return CreatePorductRequest.class;
    }
}
