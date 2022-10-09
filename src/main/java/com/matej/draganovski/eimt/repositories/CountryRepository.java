package com.matej.draganovski.eimt.repositories;

import com.matej.draganovski.eimt.models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
