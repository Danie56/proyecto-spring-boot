package com.example.proyecto_spring_boot.product.infrastructure.api;

import com.example.proyecto_spring_boot.product.infrastructure.api.dto.CreateProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.ProductDto;
import com.example.proyecto_spring_boot.product.infrastructure.api.dto.UpdateProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductApi {

    ResponseEntity<List<ProductDto>> getAllProducts();

    ResponseEntity<ProductDto> getProductById(@PathVariable Long id);

    ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto productDto);

    ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductDto product);

    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
