package com.example.exception;

import org.springframework.validation.Errors;

public class ValidationFailedException extends RuntimeException {

    private Errors errors;

    public ValidationFailedException(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
