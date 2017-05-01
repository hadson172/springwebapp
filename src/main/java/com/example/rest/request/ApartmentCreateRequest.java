package com.example.rest.request;


import javax.validation.constraints.NotNull;

public class ApartmentCreateRequest extends AbstractCreateOfferRequest {

    @NotNull
    private Integer numberOfRooms;

    @NotNull
    private Integer floorNumber;

    public ApartmentCreateRequest() {
    }


    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }
}
