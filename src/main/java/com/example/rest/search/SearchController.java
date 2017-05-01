package com.example.rest.search;

import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import com.example.rest.response.OfferResponse;
import com.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;


@RestController
@RequestMapping("${path.search}")
public class SearchController {

    private OfferService offerService;

    @Autowired
    public SearchController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping
    public List<OfferResponse> findOffers(
            @RequestParam(required = false) RealEstateType realEstateType,
            @RequestParam(required = false) OfferType offerType,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long totalArea,
            @RequestParam(required = false) Year buildYear,
            @RequestParam(required = false) LocalDateTime creationTime) {

        return offerService.findAll(new SpecificationBuilder()
                .realEstateType(realEstateType)
                .offerType(offerType)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .city(city)
                .totalArea(totalArea)
                .buildYear(buildYear)
                .creationTime(creationTime)
                .buildSpecification());
    }

}
