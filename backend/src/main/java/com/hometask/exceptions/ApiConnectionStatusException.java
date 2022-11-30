package com.hometask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Cannot connect to NPB api")
public class ApiConnectionStatusException extends RuntimeException {
    public ApiConnectionStatusException(String message) {
        super(message);
    }
}
