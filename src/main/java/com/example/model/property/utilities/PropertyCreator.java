package com.example.model.property.utilities;

import com.example.model.account.User;
import com.example.model.property.AbstractProperty;
import com.example.model.property.House;
import com.example.model.property.Plot;
import com.example.model.property.Warehouse;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Component
public class PropertyCreator {

    private final Map<AbstractProperty.Type, Creator> map;

    public PropertyCreator() {
        map = new HashMap<>();
        map.put(AbstractProperty.Type.HOUSE, House::new);
        map.put(AbstractProperty.Type.WAREHOUSE, Warehouse::new);
        map.put(AbstractProperty.Type.PLOT, Plot::new);
    }

    public AbstractProperty createProperty(User owner, AbstractProperty.Type type, double price, double area, Year buildYear) {
        return map.get(type).create(owner, price, area, buildYear);
    }


    @FunctionalInterface
    private interface Creator {
        AbstractProperty create(User owner, double price, double area, Year buildYear);
    }

}

