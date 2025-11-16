package com.example.proyecto_spring_boot.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResult<T> {
    private List<T> content;
    private int totalElements;
    private int totalPages;
    private int pageNumber;

}
