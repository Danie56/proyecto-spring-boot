package com.example.proyecto_spring_boot.product.infrastructure.api;

import com.example.proyecto_spring_boot.common.mediator.Mediator;
import com.example.proyecto_spring_boot.product.aplication.create.CreatePorductRequest;
import com.example.proyecto_spring_boot.product.aplication.get.GetProductByIdRequest;
import com.example.proyecto_spring_boot.product.aplication.get.GetProductByIdResponse;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;

    private final ProductDtoMapper productDtoMapper;


    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {

        return null;


    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        CreatePorductRequest createProductRequest = productDtoMapper.mapToProductCreateRequest(productDto);
        mediator.dispatch(createProductRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(Long id) {

        GetProductByIdResponse response = mediator.dispatch(new GetProductByIdRequest(id));
        ProductDto productDto = productDtoMapper.mapToProductDto(response.getProduct());

        return ResponseEntity.ok(productDto);


    }

    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return null;


    }

}
