package com.example.repository;

import com.example.model.offer.realestate.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Optional<Apartment> findApartmentById(Long id);
}
