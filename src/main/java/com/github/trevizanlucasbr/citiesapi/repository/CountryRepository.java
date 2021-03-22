package com.github.trevizanlucasbr.citiesapi.repository;

import com.github.trevizanlucasbr.citiesapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
