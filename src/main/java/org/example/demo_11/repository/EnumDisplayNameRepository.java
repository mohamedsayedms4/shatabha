package org.example.demo_11.repository;

import org.example.demo_11.model.EnumDisplayName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnumDisplayNameRepository
        extends JpaRepository<EnumDisplayName, Long> {

    Optional<EnumDisplayName> findByEnumTypeAndEnumKey(
            String enumType,
            String enumKey
    );
}
