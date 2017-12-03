package com.example.model.offer.realestate;

import com.example.model.account.User;
import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import com.example.rest.response.ApartmentOfferResponse;
import com.example.rest.response.OfferResponse;

import javax.persistence.Entity;
import java.time.Year;

@Entity
public class Apartment extends AbstractOffer {

    private int numberOfRooms;
    private int floorNumber;

    public Apartment() {
    }

    public Apartment(User owner, OfferType offerType, long price, String city, long totalArea, Year buildYear, int numberOfRooms, int floorNumber) {
        super(owner, RealEstateType.APARTMENT, offerType, price, city, totalArea, buildYear);
        this.numberOfRooms = numberOfRooms;
        this.floorNumber = floorNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public OfferResponse getOfferResponse() {
        return new ApartmentOfferResponse(this);
    }
}

