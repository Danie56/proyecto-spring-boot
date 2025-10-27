package com.example.proyecto_spring_boot.product.infrastructure.api;

import com.example.proyecto_spring_boot.product.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi {

    public ArrayList<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();
        products.add(Product.builder().id(1L).name("Product 1").description("Description 1").price(111.0).image("imagen 1").build());
        products.add(Product.builder().id(2L).name("Product 2").description("Description 2").price(111.0).image("imagen 2").build());
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(products);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product productSelected = products.stream().filter(p -> p.getId().equals(product.getId())).findFirst().orElseThrow(() -> new RuntimeException("porduct not found"));
        productSelected.setName(product.getName());
        productSelected.setDescription(product.getDescription());
        productSelected.setPrice(product.getPrice());
        productSelected.setImage(product.getImage());
        return ResponseEntity.ok(product);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        products.removeIf(product -> product.getId().equals(id));
        return ResponseEntity.noContent().build();


    }


}
