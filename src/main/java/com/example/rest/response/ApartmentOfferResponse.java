package com.example.rest.response;

import com.example.model.offer.realestate.Apartment;

public class ApartmentOfferResponse extends OfferResponse {

    private int numberOfRooms;
    private int floorNumber;

    public ApartmentOfferResponse(Apartment offer) {
        super(offer);
        this.numberOfRooms = offer.getNumberOfRooms();
        this.floorNumber = offer.getFloorNumber();

    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
