package com.example.proyecto_spring_boot.product.domain.entity;

import com.example.proyecto_spring_boot.ProductDetails.domain.ProductDetail;
import com.example.proyecto_spring_boot.categories.domain.entity.Category;
import com.example.proyecto_spring_boot.review.domain.Review;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private ProductDetail productDetail;
    private List<Review> reviews = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();



}
