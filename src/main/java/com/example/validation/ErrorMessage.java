package com.example.validation;

public enum ErrorMessage {
    USER_WITH_GIVEN_USERNAME_ALREADY_EXISTS("User with given username already exists"),
    REPEATED_PASSWORD_DOES_NOT_MATCH_PASSWORD("Repeated password does not match password");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
