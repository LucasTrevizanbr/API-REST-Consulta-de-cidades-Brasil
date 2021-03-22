package com.github.trevizanlucasbr.citiesapi.controller;

import com.github.trevizanlucasbr.citiesapi.model.State;
import com.github.trevizanlucasbr.citiesapi.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public Page<State> getAllStates(Pageable page){
        return stateRepository.findAll(page);
    }
}
