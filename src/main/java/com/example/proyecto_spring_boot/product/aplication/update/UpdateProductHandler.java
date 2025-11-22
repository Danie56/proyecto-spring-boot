package com.example.proyecto_spring_boot.product.aplication.update;

import com.example.proyecto_spring_boot.ProductDetails.domain.ProductDetail;
import com.example.proyecto_spring_boot.categories.domain.entity.Category;
import com.example.proyecto_spring_boot.categories.domain.port.CategoryRepository;
import com.example.proyecto_spring_boot.common.application.mediator.HandlerManage;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UpdateProductHandler implements HandlerManage<UpdateProductRequest, UpdateProductResponse> {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public UpdateProductResponse handle(UpdateProductRequest request) {
        List<Category> categories = categoryRepository.getByIds(request.getCategories());
        Product productFound = productRepository.getById(request.getId());
        ProductDetail productDetail = ProductDetail.builder()
                .id(productFound.getProductDetail().getId())
                .specifications(request.getProductDetail().getSpecifications())
                .warranty(request.getProductDetail().getWarranty())
                .provider(request.getProductDetail().getProvider())
                .build();

        Product product =Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(request.getImage())
                .productDetail(productDetail)
                .categories(categories)
                .build();
        Product save =productRepository.upsert(product);

        return new UpdateProductResponse(save);
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
