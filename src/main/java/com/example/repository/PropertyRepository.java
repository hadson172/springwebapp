package com.example.repository;

import com.example.model.property.AbstractProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<AbstractProperty, Long> {

    List<AbstractProperty> findAllByOwnerUsername(String username);

}
