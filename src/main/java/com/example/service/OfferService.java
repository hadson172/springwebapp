package com.example.service;

import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import com.example.repository.OfferRepository;
import com.example.rest.response.OfferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private OfferRepository offerRepository;
    private UserService userService;

    @Autowired
    public OfferService(OfferRepository offerRepository, UserService userService) {
        this.offerRepository = offerRepository;
        this.userService = userService;
    }

    public AbstractOffer save(AbstractOffer offer) {
        return offerRepository.save(offer);
    }

    public List<AbstractOffer> findUsingCriteria(RealEstateType realEstateType, OfferType offerType, Long minPrice, Long maxPrice, String city, Long totalArea, Year buildYear, LocalDateTime creationTime)
    {
        return offerRepository.findAllOffersUsingCriteria(realEstateType,offerType,minPrice,maxPrice,city,totalArea,buildYear,creationTime);
    }

    public List<OfferResponse> findAllOfferResponse(RealEstateType realEstateType, OfferType offerType, Long minPrice, Long maxPrice, String city, Long totalArea, Year buildYear, LocalDateTime creationTime) {
        return offerRepository.findAllOffersUsingCriteria(realEstateType,offerType,minPrice,maxPrice,city,totalArea,buildYear,creationTime).stream().map(AbstractOffer::getOfferResponse).collect(Collectors.toList());
    }

    public List<OfferResponse> findAll(Specification<AbstractOffer> offerSpecification) {
        return offerRepository.findAll(offerSpecification).stream().map(AbstractOffer::getOfferResponse).collect(Collectors.toList());
    }

    public Optional<AbstractOffer> findOfferById(Long id) {
        return offerRepository.findById(id);
    }

    public void deleteOffer(Long id) {
         offerRepository.delete(id);
    }

    public boolean isOwner(Long id, Authentication authentication) {
       return userService.getAuthenticatedUser(authentication)
                .map(u -> u.getId().equals(id))
                .orElse(false);
    }

}
