package com.mcdonalds.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientExistException extends Exception{

    private static final String MESSAGE = "Client not exist";


    public ClientExistException() {
        super(MESSAGE);
    }
}

