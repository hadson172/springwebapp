package com.example.service;

import com.example.model.property.AbstractProperty;
import com.example.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public AbstractProperty saveProperty(AbstractProperty abstractProperty) {
        return propertyRepository.save(abstractProperty);
    }

    public List<AbstractProperty> findAllPropertiesByOwner(String username) {
        return propertyRepository.findAllByOwnerUsername(username);
    }
}
