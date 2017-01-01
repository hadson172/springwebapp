package com.example.rest.update;

import com.example.exception.ResourceNotFoundException;
import com.example.model.property.AbstractProperty;
import com.example.model.property.House;
import com.example.model.property.Warehouse;
import com.example.rest.request.UpdateHouseRequest;
import com.example.rest.request.UpdatePropertyRequest;
import com.example.rest.request.UpdateWarehouseRequest;
import com.example.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("${path.update}")
public class UpdatePropertyController {

    private PropertyService propertyService;

    @Autowired
    public UpdatePropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("{id}")
    @PreAuthorize("hasPermission(#id,'AbstractProperty','delete')")
    public void updateProperty(@PathVariable Long id, @RequestBody UpdatePropertyRequest request) {

        AbstractProperty abstractProperty = propertyService.findPropertyById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        abstractProperty.setArea(request.getArea());
        abstractProperty.setBuildYear(request.getBuildYear());
        abstractProperty.setPrice(request.getPrice());

        propertyService.saveProperty(abstractProperty);

    }

    @PostMapping("/house/{id}")
    @PreAuthorize("hasPermission(#id,'AbstractProperty','delete')")
    public void updateHouse(@PathVariable Long id, @RequestBody UpdateHouseRequest request) {

        AbstractProperty abstractProperty = propertyService.findAllByTypeAndId(AbstractProperty.Type.HOUSE, id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        House house = (House) abstractProperty;
        house.setHouseType(request.getHouseType());
        house.setNumberOfStorey(request.getNumberOfStorey());

        propertyService.saveProperty(house);
    }

    @PostMapping("/warehouse/{id}")
    @PreAuthorize("hasPermission(#id,'AbstractProperty','delete')")
    public void updateWarehouse(@PathVariable Long id, @RequestBody UpdateWarehouseRequest request) {
        AbstractProperty abstractProperty = propertyService.findAllByTypeAndId(AbstractProperty.Type.WAREHOUSE, id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        Warehouse warehouse = (Warehouse) abstractProperty;
        warehouse.setStorageArea(request.getStorageArea());

        propertyService.saveProperty(warehouse);

    }

    @PostMapping("/plot/{id}")
    @PreAuthorize("hasPermission(#id,'AbstractProperty','delete')")
    public void updatePlot(@PathVariable Long id) {

        //TODO
    }
}
