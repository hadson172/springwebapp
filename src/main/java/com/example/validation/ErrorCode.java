package com.example.validation;

public enum ErrorCode {
    USER_EXISTS("userExists"),
    PASSWORDS_NOT_MATCH("passwordsNotMatch");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
