package com.example.proyecto_spring_boot.product.infrastructure.api;


import com.example.proyecto_spring_boot.common.mediator.Mediator;
import com.example.proyecto_spring_boot.product.aplication.get.getAll.GetAllProductRequest;
import com.example.proyecto_spring_boot.product.aplication.get.getAll.GetAllProductResponse;
import com.example.proyecto_spring_boot.product.aplication.get.getById.GetProductByIdRequest;
import com.example.proyecto_spring_boot.product.aplication.get.getById.GetProductByIdResponse;
import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.mapper.ProductDtoMapper;
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

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
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
                Product.builder().id(3L).build(),
                Product.builder().id(4L).build()


        ));
        Mockito.when(mediator.dispatch(any(GetAllProductRequest.class))).thenReturn(response);
        ResponseEntity<List<ProductDto>> request = productController.getAllProducts();
        Assertions.assertEquals(HttpStatus.OK, request.getStatusCode());
    }

    @Test
    public void getProductById() {
        GetProductByIdResponse response = new GetProductByIdResponse(Product.builder().id(1L).build());

        Mockito.when(mediator.dispatch(any(GetProductByIdRequest.class))).thenReturn(response);
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        Mockito.when(productDtoMapper.mapToProductDto(any(Product.class))).thenReturn(productDto);

        ResponseEntity<ProductDto> request = productController.getProductById(1L);
        Assertions.assertNotNull(request.getBody());
        Assertions.assertEquals(1L, request.getBody().getId());


    }


}