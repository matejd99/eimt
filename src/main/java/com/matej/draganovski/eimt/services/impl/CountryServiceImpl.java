package com.matej.draganovski.eimt.services.impl;

import com.matej.draganovski.eimt.dtos.CountryDto;
import com.matej.draganovski.eimt.mappers.Mapper;
import com.matej.draganovski.eimt.models.Country;
import com.matej.draganovski.eimt.repositories.CountryRepository;
import com.matej.draganovski.eimt.requests.CreateCountryRequest;
import com.matej.draganovski.eimt.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repo;

    public CountryServiceImpl(CountryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CountryDto> listCountries() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(Mapper::toCountryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto createCountry(CreateCountryRequest request) {
        Country country = new Country();
        country.setName(request.getName());
        country.setContinent(request.getContinent());

        Country result = repo.save(country);

        return Mapper.toCountryDto(result);
    }
}
