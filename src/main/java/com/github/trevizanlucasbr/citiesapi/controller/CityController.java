package com.github.trevizanlucasbr.citiesapi.controller;

import com.github.trevizanlucasbr.citiesapi.model.City;
import com.github.trevizanlucasbr.citiesapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> getAllCities(final Pageable page){
        return cityRepository.findAll(page);
    }
}
