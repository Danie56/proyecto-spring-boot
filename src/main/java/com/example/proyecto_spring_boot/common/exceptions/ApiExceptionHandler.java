package com.example.proyecto_spring_boot.common.exceptions;

import com.example.proyecto_spring_boot.product.domain.execptions.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public ErrorMessage batRequest(HttpServletRequest request, MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> {

            errors.put(e.getField(), e.getDefaultMessage());
        });
        return new ErrorMessage(exception.getMessage(), exception.getClass().getSimpleName(), request.getRequestURI(), errors);

    }

    @ResponseBody
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ErrorMessage notFound(HttpServletRequest request, ProductNotFoundException exception) {


        return new ErrorMessage(exception.getMessage(), exception.getClass().getSimpleName(), request.getRequestURI());

    }
}
