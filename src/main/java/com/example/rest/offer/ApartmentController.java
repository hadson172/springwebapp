package com.example.rest.offer;

import com.example.model.offer.realestate.Apartment;
import com.example.rest.request.ApartmentCreateRequest;
import com.example.rest.utilities.RestUtils;
import com.example.service.OfferService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("${path.apartment}")
public class ApartmentController {

    private UserService userService;
    private OfferService offerService;

    @Autowired
    public ApartmentController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createApartmentOffer(@Valid @RequestBody ApartmentCreateRequest request, Errors errors, Authentication authentication) {
        RestUtils.hasErrors(errors);

        userService.getAuthenticatedUser(authentication).ifPresent(user -> {
            Apartment apartment = new Apartment(user,request.getOfferType(),request.getPrice(),request.getCity(),request.getTotalArea(),request.getBuildYear(),request.getNumberOfRooms(),request.getFloorNumber());
            offerService.save(apartment);
        });

    }
}
