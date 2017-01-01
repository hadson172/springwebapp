package com.example.rest.property;

import com.example.exception.ValidationFailedException;
import com.example.model.account.User;
import com.example.model.property.AbstractProperty;
import com.example.model.property.utilities.PropertyCreator;
import com.example.rest.request.PropertyCreateRequest;
import com.example.service.PropertyService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${path.property}")
public class PropertyController {

    private UserService userService;
    private PropertyCreator creator;
    private PropertyService propertyService;

    @Autowired
    public PropertyController(UserService userService, PropertyCreator creator, PropertyService propertyService) {
        this.userService = userService;
        this.creator = creator;
        this.propertyService = propertyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProperty(@Valid @RequestBody PropertyCreateRequest request, Errors errors, Authentication authentication) {
        if (errors.hasErrors()) throw new ValidationFailedException(errors);

        Optional<User> owner = userService.findUserByUsername(authentication.getName());

        owner.ifPresent(user -> {
            AbstractProperty property = creator.createProperty(user, request.getType(), request.getPrice(), request.getArea(), request.getBuildYear());
            propertyService.saveProperty(property);
        });
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AbstractProperty> getAllOwnedProperty(Authentication authentication) {
        return propertyService.findAllPropertiesByOwner(authentication.getName());
    }

    @DeleteMapping("/{propertyId}")
    @PreAuthorize("hasPermission(#propertyId,'AbstractProperty','delete')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProperty(@PathVariable Long propertyId) {
        propertyService.deleteProperty(propertyId);
    }

}
