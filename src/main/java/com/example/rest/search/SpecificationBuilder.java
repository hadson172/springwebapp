package com.example.rest.search;

import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecificationBuilder {

    private RealEstateType realEstateType;
    private OfferType offerType;
    private Long minPrice;
    private Long maxPrice;
    private String city;
    private Long totalArea;
    private Year buildYear;
    private LocalDateTime creationTime;

    private List<Predicate> predicates = new ArrayList<>();

    public SpecificationBuilder() {

    }


    public SpecificationBuilder realEstateType(RealEstateType realEstateType) {
        this.realEstateType = realEstateType;
        return this;
    }

    public SpecificationBuilder offerType(OfferType offerType) {
        this.offerType = offerType;
        return this;
    }

    public SpecificationBuilder minPrice(Long minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public SpecificationBuilder maxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public SpecificationBuilder city(String city) {
        this.city = city;
        return this;
    }

    public SpecificationBuilder totalArea(Long totalArea) {
        this.totalArea = totalArea;
        return this;
    }

    public SpecificationBuilder buildYear(Year buildYear) {
        this.buildYear = buildYear;
        return this;
    }

    public SpecificationBuilder creationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
        return this;
    }


    public Specification<AbstractOffer> buildSpecification() {

        return (Root<AbstractOffer> root,CriteriaQuery<?> query,CriteriaBuilder builder) ->{

            List<Predicate> predicates = new ArrayList<>();

            Optional.ofNullable(this.realEstateType).ifPresent(v -> predicates.add(builder.equal(root.get("realEstateType"),v)));
            Optional.ofNullable(this.offerType).ifPresent(v -> predicates.add(builder.equal(root.get("offerType"),v)));
            Optional.ofNullable(this.minPrice).ifPresent(v -> predicates.add(builder.greaterThanOrEqualTo(root.get("minPrice"),v)));
            Optional.ofNullable(this.maxPrice).ifPresent(v -> predicates.add(builder.lessThanOrEqualTo(root.get("maxPrice"),v)));
            Optional.ofNullable(this.city).ifPresent(v -> predicates.add(builder.equal(root.get("city"),v)));
            Optional.ofNullable(this.totalArea).ifPresent(v -> predicates.add(builder.greaterThanOrEqualTo(root.get("totalArea"),v)));
            Optional.ofNullable(this.buildYear).ifPresent(v -> predicates.add(builder.equal(root.get("buildYear"),v)));
            Optional.ofNullable(this.creationTime).ifPresent(v -> predicates.add(builder.equal(root.get("creationTime"),v)));

            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
