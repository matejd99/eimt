package com.matej.draganovski.eimt.services.impl;


import com.matej.draganovski.eimt.dtos.AuthorDto;
import com.matej.draganovski.eimt.mappers.Mapper;
import com.matej.draganovski.eimt.models.Author;
import com.matej.draganovski.eimt.models.Country;
import com.matej.draganovski.eimt.repositories.AuthorRepository;
import com.matej.draganovski.eimt.repositories.CountryRepository;
import com.matej.draganovski.eimt.requests.CreateAuthorRequest;
import com.matej.draganovski.eimt.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repo;
    private final CountryRepository countryRepo;

    public AuthorServiceImpl(AuthorRepository repo, CountryRepository countryRepo) {
        this.repo = repo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<AuthorDto> listAuthors() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(Mapper::toAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorRequest request) {
        Optional<Country> country = countryRepo.findById(request.getCountry());

        if (country.isEmpty()) {
            throw new RuntimeException("Country not found");
        }

        Author author = new Author();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setCountry(country.get());

        Author result = repo.save(author);

        return Mapper.toAuthorDto(result);
    }
}
