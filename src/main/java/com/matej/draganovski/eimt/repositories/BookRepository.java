package com.matej.draganovski.eimt.repositories;

import com.matej.draganovski.eimt.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
