package com.mcdonalds.ecommerce.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNoExistException extends Exception {

    public ClientNoExistException(String message) {
        super(message);
    }

    public ClientNoExistException() {

    }
}
