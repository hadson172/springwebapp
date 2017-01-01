package com.example.repository;

import com.example.model.property.AbstractProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<AbstractProperty, Long> {

    List<AbstractProperty> findAllByOwnerUsername(String username);

    Optional<AbstractProperty> findByOwnerUsernameAndId(String username, Long id);

    Optional<AbstractProperty> findPropertyById(Long id);

    Optional<AbstractProperty> findByTypeAndId(AbstractProperty.Type type, Long id);

}
