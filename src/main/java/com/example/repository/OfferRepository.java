package com.example.repository;

import com.example.model.offer.AbstractOffer;
import com.example.model.offer.OfferType;
import com.example.model.offer.RealEstateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<AbstractOffer, Long>, JpaSpecificationExecutor<AbstractOffer> {


    @Query("SELECT o FROM AbstractOffer o WHERE " +
            "(:realEstateType IS NULL OR o.realEstateType = :realEstateType) AND" +
            "(:offerType IS NULL OR o.offerType = :offerType) AND" +
            "(:minPrice IS NULL OR o.price > :minPrice) AND" +
            "(:maxPrice IS NULL OR o.price < :maxPrice) AND" +
            "(:city IS NULL OR o.city = :city) AND " +
            "(:totalArea IS NULL OR o.totalArea > :totalArea) AND " +
            "(:buildYear IS NULL OR o.buildYear = :buildYear) AND " +
            "(:creationTime IS NULL OR o.creationTime = :creationTime)")
    List<AbstractOffer> findAllOffersUsingCriteria(@Param("realEstateType") RealEstateType realEstateType,
                                                   @Param("offerType") OfferType offerType,
                                                   @Param("minPrice") Long minPrice,
                                                   @Param("maxPrice") Long maxPrice,
                                                   @Param("city") String city,
                                                   @Param("totalArea") Long totalArea,
                                                   @Param("buildYear") Year buildYear,
                                                   @Param("creationTime") LocalDateTime creationTime);


    Optional<AbstractOffer> findById(Long id);


    boolean deleteAbstractOfferById(Long id);

    @Transactional
    boolean deleteAbstractOfferByIdAndOwnerUsername(Long id, String username);

}
