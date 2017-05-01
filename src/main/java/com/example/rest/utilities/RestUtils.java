package com.example.rest.utilities;

import com.example.exception.ValidationFailedException;
import org.springframework.validation.Errors;

public class RestUtils {

    public static void hasErrors(Errors errors) {
        if (errors.hasErrors()) throw new ValidationFailedException(errors);
    }
}
