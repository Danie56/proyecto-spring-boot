package com.example.proyecto_spring_boot.product.infrastructure.database.entity;

import com.example.proyecto_spring_boot.ProductDetails.infrastructure.database.ProductDetailEntity;
import com.example.proyecto_spring_boot.categories.infrastructure.database.entity.CategoryEntity;
import com.example.proyecto_spring_boot.review.infrastructure.database.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToMany
    @JoinTable(name = "products_categories",joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id") )
    private List<CategoryEntity> categories = new ArrayList<>();

}
