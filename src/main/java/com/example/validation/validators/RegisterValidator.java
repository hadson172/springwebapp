package com.example.validation.validators;

import com.example.model.account.User;
import com.example.security.request.RegisterRequest;
import com.example.service.UserService;
import com.example.validation.ErrorCode;
import com.example.validation.ErrorField;
import com.example.validation.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class RegisterValidator implements Validator {

    private UserService userService;

    @Autowired
    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterRequest request = (RegisterRequest) o;

        if (request.getRepeatedPassword().equals(request.getPassword())) {
            errors.rejectValue(ErrorField.REPEATED_PASSWORD.getField(), ErrorCode.PASSWORDS_NOT_MATCH.getCode(),
                    ErrorMessage.REPEATED_PASSWORD_DOES_NOT_MATCH_PASSWORD.getMessage());
        }

        Optional<User> userOptional = userService.findUserByUsername(request.getUsername());

        userOptional.ifPresent(e -> errors.rejectValue(ErrorField.USERNAME.getField(), ErrorCode.USER_EXISTS.getCode(),
                ErrorMessage.USER_WITH_GIVEN_USERNAME_ALREADY_EXISTS.getMessage()));

    }
}
