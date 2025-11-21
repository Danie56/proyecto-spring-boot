package com.example.proyecto_spring_boot.product.infrastructure.database.entity;

import com.example.proyecto_spring_boot.ProductDetails.infrastructure.database.ProductDetailEntity;
import com.example.proyecto_spring_boot.review.infrastructure.database.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 500)
    private String description;
    private Double price;
    private String image;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_details_id")
    private ProductDetailEntity productDetail;
    @OneToMany(mappedBy = "product")
    private List<ReviewEntity> reviews = new ArrayList<>();
}
