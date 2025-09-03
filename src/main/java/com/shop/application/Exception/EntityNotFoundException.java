package com.shop.application.Exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException  extends RuntimeException{

    private final HttpStatus status;

    public EntityNotFoundException(final HttpStatus status, final String message, final Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public EntityNotFoundException(final HttpStatus status, final String message) {
        this(status, message, null);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
