package com.example.rest.search;

import com.example.model.property.AbstractProperty;
import com.example.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("${path.search}")
public class SearchController {

    private PropertyService propertyService;

    @Autowired
    public SearchController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<AbstractProperty> getAllProperties() {
        return propertyService.findAll();
    }
}
