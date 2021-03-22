package com.github.trevizanlucasbr.citiesapi.controller;

import com.github.trevizanlucasbr.citiesapi.model.Country;
import com.github.trevizanlucasbr.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> getAllCountries(Pageable page){
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCountry(@PathVariable Long id){
        Optional<Country> optionalCountry = countryRepository.findById(id);
        if(optionalCountry.isPresent()) {
            return ResponseEntity.ok(optionalCountry.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
