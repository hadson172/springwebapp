package com.example.rest.abstractoffer;

import com.example.exception.ResourceNotFoundException;
import com.example.model.offer.AbstractOffer;
import com.example.rest.response.OfferResponse;
import com.example.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${path.offer}")
public class AbstractOfferController {

    private OfferService offerService;


    @Autowired
    public AbstractOfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PutMapping("/{offerId}/confirmation")
    public void confirm(@RequestBody boolean confirmed, @PathVariable Long offerId) {
        AbstractOffer offer = offerService.findOfferById(offerId).orElseThrow(() -> new ResourceNotFoundException("Offer with given Id doesn't exists."));

        offer.setConfirmed(confirmed);
        offerService.save(offer);

    }

    @GetMapping("/{offerId}")
    public OfferResponse getOffer(@PathVariable Long offerId) {
        AbstractOffer offer = offerService.findOfferById(offerId).orElseThrow(() -> new ResourceNotFoundException("Offer with given Id doesn't exists."));

        return offer.getOfferResponse();
    }

    @DeleteMapping("/{offerId}")
    public void deleteOffer(@PathVariable Long offerId) {
        offerService.findOfferById(offerId).orElseThrow(() -> new ResourceNotFoundException("Offer with given Id doesn't exists."));
        offerService.deleteOffer(offerId);

    }

}
