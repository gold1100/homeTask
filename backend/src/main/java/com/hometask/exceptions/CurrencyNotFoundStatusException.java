package com.hometask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Currency not found")
public class CurrencyNotFoundStatusException extends RuntimeException{

    public CurrencyNotFoundStatusException() {
    }

    public CurrencyNotFoundStatusException(String message) {
        super(message);
    }
}
