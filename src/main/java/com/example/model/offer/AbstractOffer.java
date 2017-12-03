package com.example.model.offer;

import com.example.model.account.User;
import com.example.rest.response.OfferResponse;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractOffer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User owner;

    @Enumerated(EnumType.STRING)
    private RealEstateType realEstateType;

    @Enumerated(EnumType.STRING)
    private OfferType offerType;

    @ElementCollection
    private Map<String, String> additionalProperties;

    private boolean confirmed;

    private long price;
    private String city;
    private long totalArea;
    private Year buildYear;

    @Column(updatable = false)
    private LocalDateTime creationTime;

    public AbstractOffer() {

    }


    public AbstractOffer(User owner, RealEstateType realEstateType, OfferType offerType, long price, String city, long totalArea, Year buildYear) {
        this.owner = owner;
        this.realEstateType = realEstateType;
        this.offerType = offerType;
        this.price = price;
        this.city = city;
        this.totalArea = totalArea;
        this.buildYear = buildYear;
        this.additionalProperties = new HashMap<>();
    }

    @PrePersist
    public void setTimeStamp() {
        this.creationTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public void setRealEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
    }

    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, String> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(long totalArea) {
        this.totalArea = totalArea;
    }

    public Year getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Year buildYear) {
        this.buildYear = buildYear;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public abstract OfferResponse getOfferResponse();


}

