package com.example.rest.request;

import com.example.model.property.AbstractProperty;

import javax.validation.constraints.NotNull;
import java.time.Year;

public class PropertyCreateRequest {

    @NotNull
    private AbstractProperty.Type type;

    private double price;
    private Year buildYear;
    private double area;

    public PropertyCreateRequest() {
    }

    public AbstractProperty.Type getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Year getBuildYear() {
        return buildYear;
    }

    public double getArea() {
        return area;
    }
}
