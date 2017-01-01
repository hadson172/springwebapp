package com.example.rest.request;

import java.time.Year;

public class UpdatePropertyRequest {

    private double price;
    private double area;
    private Year buildYear;

    public UpdatePropertyRequest() {
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public Year getBuildYear() {
        return buildYear;
    }
}
