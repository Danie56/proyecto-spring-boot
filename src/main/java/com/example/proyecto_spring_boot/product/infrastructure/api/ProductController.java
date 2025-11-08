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
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.CreateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.UpdateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.mapper.ProductDtoMapper;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        GetAllProductResponse response = mediator.dispatch(new GetAllProductRequest());
        List<ProductDto> products = response.getProducts().stream().map(productDtoMapper::mapToProductDto).toList();

        return ResponseEntity.ok(products);


    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody @Valid CreateProductDto productDto) {
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
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductDto productDto) {
        UpdateProductRequest request = productDtoMapper.mapToProductUpdateRequest(productDto);
        UpdateProductResponse response = mediator.dispatch(request);

        return ResponseEntity.ok(productDtoMapper.mapToProductDto(response.getProduct()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        mediator.dispatch(new DeleteProductRequest(id));
        return ResponseEntity.noContent().build();


    }

}
