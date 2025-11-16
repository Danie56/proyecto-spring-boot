package com.example.proyecto_spring_boot.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Array;

@Data
@AllArgsConstructor
public class PaginationQuery {

    private int pageNumber;
    private int pageSize;
    private String direction;
    private String properties;
}
