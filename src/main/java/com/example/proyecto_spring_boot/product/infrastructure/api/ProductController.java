package com.example.proyecto_spring_boot.product.infrastructure.api;

import com.example.proyecto_spring_boot.common.mediator.Mediator;
import com.example.proyecto_spring_boot.product.aplication.ProductCreateRequest;
import com.example.proyecto_spring_boot.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    public final ArrayList<Product> products;
    private final Mediator mediator;


    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(products);


    }

    @PostMapping("")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        ProductCreateRequest productCreateRequest = new ProductCreateRequest(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImage());
        mediator.dispatch(productCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


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
