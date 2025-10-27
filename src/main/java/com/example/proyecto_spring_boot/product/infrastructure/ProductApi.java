package com.example.proyecto_spring_boot.product.infrastructure;

import com.example.proyecto_spring_boot.product.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductApi {

    ResponseEntity<List<Product>> getAllProducts();

    ResponseEntity<Product> getProductById(@PathVariable Long id);

    ResponseEntity<Void> createProduct(@RequestBody Product product);

    ResponseEntity<Product> updateProduct(@RequestBody Product product);

    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
