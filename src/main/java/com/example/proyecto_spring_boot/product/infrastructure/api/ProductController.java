package com.example.proyecto_spring_boot.product.infrastructure.api;

import com.example.proyecto_spring_boot.common.mediator.Mediator;
import com.example.proyecto_spring_boot.product.aplication.create.ProductCreateRequest;
import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductCreateDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final Mediator mediator;

    private final ProductMapper productMapper;


    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {

        return null;


    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateDto productCreateDto) {
        ProductCreateRequest productCreateRequest = productMapper.mapToProductCreateRequest(productCreateDto);
        mediator.dispatch(productCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return null;


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
