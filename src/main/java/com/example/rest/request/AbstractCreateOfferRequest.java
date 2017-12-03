package com.example.rest.request;

import com.example.model.offer.OfferType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.Map;

public abstract class AbstractCreateOfferRequest {


    @NotNull
    private OfferType offerType;

    @NotNull
    private Long price;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    private Long totalArea;

    @NotNull
    private Year buildYear;

    @NotNull
    private Map<String, String> additionalProperties;


    public AbstractCreateOfferRequest() {

    }

    public Long getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public Long getTotalArea() {
        return totalArea;
    }

    public Year getBuildYear() {
        return buildYear;
    }


    public OfferType getOfferType() {
        return offerType;
    }

    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }
}
