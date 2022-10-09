package com.matej.draganovski.eimt.services;

import com.matej.draganovski.eimt.dtos.BookDto;
import com.matej.draganovski.eimt.requests.CreateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<BookDto> listBooks();
    Page<BookDto> listBooksPaged(Pageable request);
    BookDto createBook(CreateBookRequest request);
    BookDto updateBook(Long id, CreateBookRequest request);
    BookDto borrowBook(Long id);
    void deleteBook(Long id);
}
