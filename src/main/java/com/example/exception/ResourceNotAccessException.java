package com.example.exception;

public class ResourceNotAccessException extends RuntimeException {

    public ResourceNotAccessException(String message) {
        super(message);
    }
}
