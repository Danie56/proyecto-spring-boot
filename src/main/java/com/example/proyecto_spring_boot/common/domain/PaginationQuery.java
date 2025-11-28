package com.example.proyecto_spring_boot.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Array;

@Data
@Builder
@AllArgsConstructor
public class PaginationQuery {

    private int pageNumber;
    private int pageSize;
    private String direction;
    private String properties;
    private String byName;
    private Double priceMin;
    private Double priceMax;

}
