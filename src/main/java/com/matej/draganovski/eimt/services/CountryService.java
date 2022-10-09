package com.matej.draganovski.eimt.services;

import com.matej.draganovski.eimt.dtos.CountryDto;
import com.matej.draganovski.eimt.requests.CreateCountryRequest;

import java.util.List;

public interface CountryService {
    List<CountryDto> listCountries();
    CountryDto createCountry(CreateCountryRequest request);
}
