package com.mcdonalds.ecommerce.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNoAvailableExistException extends Exception {

    public ProductNoAvailableExistException(String message) {
        super(message);
    }

    public ProductNoAvailableExistException() {

    }
}
