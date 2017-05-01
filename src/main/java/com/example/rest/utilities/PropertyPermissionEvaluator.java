package com.example.rest.utilities;

import com.example.model.account.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class PropertyPermissionEvaluator { /*implements PermissionEvaluator {

    private PropertyService propertyService;

    @Autowired
    public PropertyPermissionEvaluator(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {

        throw new UnsupportedOperationException();

    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {

        if (authentication.getAuthorities().stream()
                .anyMatch(e -> e.getAuthority().equals(Role.ADMIN.getRole()))) {
            return true;
        }

        if (serializable instanceof Long) {
            Long id = (Long) serializable;
            return propertyService.isOwner(authentication.getName(), id);
        }

        return false;

    }*/
}
