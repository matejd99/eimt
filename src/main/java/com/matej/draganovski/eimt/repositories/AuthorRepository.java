package com.matej.draganovski.eimt.repositories;

import com.matej.draganovski.eimt.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
