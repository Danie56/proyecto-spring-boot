package com.example.proyecto_spring_boot.review.infrastructure.database.entity;

import com.example.proyecto_spring_boot.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private Integer score;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private ProductEntity product;

}
