package com.example.service;

import com.example.model.property.AbstractProperty;
import com.example.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<AbstractProperty> findByOwnerUsernameAndId(String username, Long id) {
        return propertyRepository.findByOwnerUsernameAndId(username, id);
    }

    public boolean isOwner(String username, Long id) {
        return propertyRepository.findByOwnerUsernameAndId(username, id).isPresent();
    }

    public void deleteProperty(Long id) {
        propertyRepository.delete(id);
    }

    public List<AbstractProperty> findAll() {
        return propertyRepository.findAll();
    }

    public Optional<AbstractProperty> findPropertyById(Long id) {
        return propertyRepository.findPropertyById(id);
    }

    public Optional<AbstractProperty> findAllByTypeAndId(AbstractProperty.Type type, Long id) {
        return propertyRepository.findByTypeAndId(type, id);
    }
}
