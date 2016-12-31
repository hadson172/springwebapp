package com.example.rest.request;

import com.example.model.property.AbstractProperty;

import javax.validation.constraints.NotNull;

public class PropertyCreateRequest {

    @NotNull
    private AbstractProperty.Type type;

    private double price;
    private int age;
    private double size;

    public PropertyCreateRequest() {
    }

    public AbstractProperty.Type getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAge() {
        return age;
    }

    public double getSize() {
        return size;
    }
}
