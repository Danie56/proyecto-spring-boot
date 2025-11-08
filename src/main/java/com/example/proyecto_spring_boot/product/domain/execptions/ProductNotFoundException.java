package com.example.proyecto_spring_boot.product.domain.execptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Product with id: " + id + " was not found");
    }
}
