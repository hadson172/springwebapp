package com.example.rest.utilities;

import org.springframework.stereotype.Component;

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
