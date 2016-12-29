package com.example.validation;

public enum ErrorField {

    USERNAME("username"),
    REPEATED_PASSWORD("repeatedPassword");

    private final String field;

    ErrorField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
