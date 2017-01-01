package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = ValidationFailedException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationException(ValidationFailedException ex) {
        Map<String, List<String>> errors = ex.getErrors().getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())));
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
