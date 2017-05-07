package com.example.validation.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ErrorMsg {

    @Value("${userNotFound}")
    private static String USER_NOT_FOUND;
}
