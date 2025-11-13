package com.example.proyecto_spring_boot.product.infrastructure.api;


import com.example.proyecto_spring_boot.common.mediator.Mediator;
import com.example.proyecto_spring_boot.product.aplication.create.CreatePorductRequest;
import com.example.proyecto_spring_boot.product.aplication.delete.DeleteProductRequest;
import com.example.proyecto_spring_boot.product.aplication.get.getAll.GetAllProductRequest;
import com.example.proyecto_spring_boot.product.aplication.get.getAll.GetAllProductResponse;
import com.example.proyecto_spring_boot.product.aplication.get.getById.GetProductByIdRequest;
import com.example.proyecto_spring_boot.product.aplication.get.getById.GetProductByIdResponse;
import com.example.proyecto_spring_boot.product.aplication.update.UpdateProductRequest;
import com.example.proyecto_spring_boot.product.aplication.update.UpdateProductResponse;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.CreateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.UpdateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.mapper.ProductDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@Slf4j
class ProductControllerTest {
    @Mock
    private Mediator mediator;
    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductDtoMapper productDtoMapper;

    @Test
    public void getAllProducts() {
        GetAllProductResponse response = new GetAllProductResponse(List.of(
                Product.builder().id(1L).build(),
                Product.builder().id(2L).build(),
                Product.builder().id(3L).build()


        ));
        Mockito.when(mediator.dispatch(any(GetAllProductRequest.class))).thenReturn(response);
        ProductDto productDto = ProductDto.builder()
                .id(1L)
                .build();
        Mockito.when(productDtoMapper.mapToProductDto(any(Product.class))).thenAnswer(invocation -> {

            Product product = invocation.getArgument(0);
            return ProductDto.builder()
                    .id(product.getId())
                    .build();
        });
        ResponseEntity<List<ProductDto>> request = productController.getAllProducts();
        Assertions.assertNotNull(request.getBody());
        assertEquals(3, request.getBody().size());
        assertEquals(HttpStatus.OK, request.getStatusCode());
    }

    @Test
    public void getProductById() {
        GetProductByIdResponse response = new GetProductByIdResponse(Product.builder().id(1L).build());

        Mockito.when(mediator.dispatch(any(GetProductByIdRequest.class))).thenReturn(response);
        ProductDto productDto = ProductDto.builder().id(1L).build();
        Mockito.when(productDtoMapper.mapToProductDto(any(Product.class))).thenReturn(productDto);

        ResponseEntity<ProductDto> request = productController.getProductById(1L);
        Assertions.assertNotNull(request.getBody());
        assertEquals(1L, request.getBody().getId());


    }

//    @Test
//    public void createProduct() {
//        Mockito.when(mediator.dispatch(any(CreatePorductRequest.class))).thenReturn(null);
//        CreatePorductRequest productRequest = new CreatePorductRequest();
//        productRequest.setName("Gaming Laptop");
//        Mockito.when(productDtoMapper.mapToProductCreateRequest(any(CreateProductDto.class))).thenReturn(productRequest);
//
//        CreateProductDto createProductDto = new CreateProductDto();
//        createProductDto.setName("Gaming Laptop");
//
//
//        ResponseEntity<Void> response = productController.createProduct(createProductDto);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//
//    }

//    @Test
//    public void updateProduct() {
//        Product product = Product.builder()
//                .id(1L)
//                .name("Gaming Laptop")
//                .build();
//
//        UpdateProductResponse response = new UpdateProductResponse(product);
//        Mockito.when(mediator.dispatch(any(UpdateProductRequest.class))).thenReturn(response);
//        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
//        updateProductRequest.setId(1L);
//        updateProductRequest.setName("Gaming Laptop");
//        Mockito.when(productDtoMapper.mapToProductUpdateRequest(any(UpdateProductDto.class))).thenReturn(updateProductRequest);
//
//        UpdateProductDto updateProductDto = new UpdateProductDto();
//        updateProductDto.setId(1L);
//        updateProductDto.setName("Gaming Laptop");
//        ProductDto productDto = ProductDto.builder()
//                .id(1L)
//                .name("Gaming Laptop")
//                .build();
//
//        Mockito.when(productDtoMapper.mapToProductDto(any(Product.class))).thenReturn(productDto);
//        ResponseEntity<ProductDto> res = productController.updateProduct(updateProductDto);
//        Assertions.assertNotNull(res.getBody());
//        log.info(res.getBody().toString());
//        assertEquals(HttpStatus.OK, res.getStatusCode());
//
//
//    }

    @Test
    public void deleteProduct() {
        Mockito.when(mediator.dispatch(any(DeleteProductRequest.class))).thenReturn(null);
        ResponseEntity<Void> response = productController.deleteProduct(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());


    }


}