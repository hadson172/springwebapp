package com.example.rest.request;


import com.example.model.property.House;

public class UpdateHouseRequest {

    private House.HouseType houseType;
    private int numberOfStorey;

    public UpdateHouseRequest() {
    }

    public House.HouseType getHouseType() {
        return houseType;
    }

    public int getNumberOfStorey() {
        return numberOfStorey;
    }
}
