package com.example.rest.response;


import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Map;

public abstract class OfferResponse {

    private Long id;

    private String ownerUsername;
    private String ownerMail;

    private boolean confirmed;

    private RealEstateType realEstateType;
    private OfferType offerType;
    private LocalDateTime creationTime;

    private long price;
    private String city;
    private long totalArea;
    private Year buildYear;

    private Map<String, String> additionalProperties;


    public OfferResponse(AbstractOffer offer) {
        this.id = offer.getId();
        this.ownerUsername = offer.getOwner().getUsername();
        this.ownerMail = offer.getOwner().getMail();
        this.realEstateType = offer.getRealEstateType();
        this.offerType = offer.getOfferType();
        this.creationTime = offer.getCreationTime();
        this.price = offer.getPrice();
        this.city = offer.getCity();
        this.totalArea = offer.getTotalArea();
        this.buildYear = offer.getBuildYear();
        this.additionalProperties = offer.getAdditionalProperties();
        this.confirmed = offer.isConfirmed();
    }

    public Long getId() {
        return id;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public long getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public long getTotalArea() {
        return totalArea;
    }

    public Year getBuildYear() {
        return buildYear;
    }

    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}

