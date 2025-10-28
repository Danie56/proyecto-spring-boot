package com.example.proyecto_spring_boot.product.infrastructure.database;

import com.example.proyecto_spring_boot.product.domain.Product;
import com.example.proyecto_spring_boot.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    public final ArrayList<Product> products;

    @Override
    public void upsert(Product product) {
        products.add(product);


    }
}
