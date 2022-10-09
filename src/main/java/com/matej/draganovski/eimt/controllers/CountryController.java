package com.matej.draganovski.eimt.controllers;

import com.matej.draganovski.eimt.dtos.CountryDto;
import com.matej.draganovski.eimt.requests.CreateCountryRequest;
import com.matej.draganovski.eimt.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CountryDto> listAll() {
        return service.listCountries();
    }

    @PostMapping
    public CountryDto create(@RequestBody CreateCountryRequest request) {
        return service.createCountry(request);
    }
}
