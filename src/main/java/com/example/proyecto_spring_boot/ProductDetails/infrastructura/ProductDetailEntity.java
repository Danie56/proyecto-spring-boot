package com.example.proyecto_spring_boot.ProductDetails.infrastructura;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_details")
@Data
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specifications;
    private String warranty;
    private String provider;
    @OneToOne(mappedBy = "productDetail")
    private ProductEntity product;

}
