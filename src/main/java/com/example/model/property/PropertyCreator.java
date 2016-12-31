package com.example.model.property;

import com.example.model.account.User;
import org.springframework.stereotype.Component;

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

    public AbstractProperty createProperty(User owner, AbstractProperty.Type type, double price, double size, int age) {
        return map.get(type).create(owner, price, size, age);
    }


    @FunctionalInterface
    private interface Creator {
        AbstractProperty create(User owner, Double price, Double size, int age);
    }

}

