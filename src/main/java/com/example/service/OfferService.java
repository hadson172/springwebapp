package com.example.service;

import com.example.exception.ResourceNotAccessException;
import com.example.exception.ResourceNotFoundException;
import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import com.example.model.offer.realestate.Apartment;
import com.example.repository.ApartmentRepository;
import com.example.repository.OfferRepository;
import com.example.rest.request.ApartmentCreateRequest;
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
    private ApartmentRepository apartmentRepository;


    @Autowired
    public OfferService(OfferRepository offerRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public AbstractOffer save(AbstractOffer offer) {
        return offerRepository.save(offer);
    }

    public List<AbstractOffer> findUsingCriteria(RealEstateType realEstateType, OfferType offerType, Long minPrice, Long maxPrice, String city, Long totalArea, Year buildYear, LocalDateTime creationTime) {
        return offerRepository.findAllOffersUsingCriteria(realEstateType, offerType, minPrice, maxPrice, city, totalArea, buildYear, creationTime);
    }

    public List<OfferResponse> findAllOfferResponse(RealEstateType realEstateType, OfferType offerType, Long minPrice, Long maxPrice, String city, Long totalArea, Year buildYear, LocalDateTime creationTime) {
        return offerRepository.findAllOffersUsingCriteria(realEstateType, offerType, minPrice, maxPrice, city, totalArea, buildYear, creationTime).stream().map(AbstractOffer::getOfferResponse).collect(Collectors.toList());
    }

    public List<OfferResponse> findAll(Specification<AbstractOffer> offerSpecification) {
        return offerRepository.findAll(offerSpecification).stream().map(AbstractOffer::getOfferResponse).collect(Collectors.toList());
    }

    public Optional<AbstractOffer> findOfferById(Long id) {
        return offerRepository.findById(id);
    }

    public void deleteOffer(AbstractOffer offer) {
        offerRepository.delete(offer);
    }

    public void deleteOfferIfOwner(Long offerId, Authentication authentication) {
        AbstractOffer offer = findOfferById(offerId).orElseThrow(() -> new ResourceNotFoundException("Offer with given Id doesn't exists."));
        if (!isOwner(offer, authentication))
            throw new ResourceNotAccessException("Cannot delete offer if you aren't owner");
        deleteOffer(offer);
    }

    public boolean isOwner(AbstractOffer offer, Authentication authentication) {
        return offer.getOwner().getUsername().equals(authentication.getName());
    }


    public Optional<Apartment> findApartmentOfferById(Long id) {
        return apartmentRepository.findApartmentById(id);
    }

    public void updateApartmentOffer(Apartment apartment, ApartmentCreateRequest apartmentCreateRequest) {
        apartment.setOfferType(apartmentCreateRequest.getOfferType());
        apartment.setTotalArea(apartmentCreateRequest.getTotalArea());
        apartment.setFloorNumber(apartmentCreateRequest.getFloorNumber());
        apartment.setNumberOfRooms(apartmentCreateRequest.getNumberOfRooms());
        apartment.setAdditionalProperties(apartmentCreateRequest.getAdditionalProperties());
        apartment.setBuildYear(apartmentCreateRequest.getBuildYear());
        apartment.setCity(apartmentCreateRequest.getCity());
        apartment.setPrice(apartmentCreateRequest.getPrice());
        offerRepository.save(apartment);
    }
}
