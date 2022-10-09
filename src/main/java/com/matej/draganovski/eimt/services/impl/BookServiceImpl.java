package com.matej.draganovski.eimt.services.impl;

import com.matej.draganovski.eimt.dtos.BookDto;
import com.matej.draganovski.eimt.mappers.Mapper;
import com.matej.draganovski.eimt.models.Author;
import com.matej.draganovski.eimt.models.Book;
import com.matej.draganovski.eimt.repositories.AuthorRepository;
import com.matej.draganovski.eimt.repositories.BookRepository;
import com.matej.draganovski.eimt.requests.CreateBookRequest;
import com.matej.draganovski.eimt.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repo;
    private final AuthorRepository authorRepo;

    public BookServiceImpl(BookRepository repo, AuthorRepository authorRepo) {
        this.repo = repo;
        this.authorRepo = authorRepo;
    }

    @Override
    public List<BookDto> listBooks() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(Mapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<BookDto> listBooksPaged(Pageable request) {
        Page<Book> books = repo.findAll(request);

        return books.map(Mapper::toBookDto);
    }

    @Override
    public BookDto createBook(CreateBookRequest request) {
        Optional<Author> author = authorRepo.findById(request.getAuthor());

        if (author.isEmpty()) {
            throw new RuntimeException("Author not found");
        }

        Book book = new Book();

        book.setAuthor(author.get());
        book.setCategory(request.getCategory());
        book.setAvailableCopies(request.getAvailableCopies());
        book.setName(request.getName());

        Book result = repo.save(book);

        return Mapper.toBookDto(result);
    }

    @Override
    public BookDto updateBook(Long id, CreateBookRequest request) {
        Book book = repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Author author = authorRepo.findById(request.getAuthor()).orElseThrow(() -> new RuntimeException("Author not found"));

        book.setAuthor(author);
        book.setCategory(request.getCategory());
        book.setAvailableCopies(request.getAvailableCopies());
        book.setName(request.getName());

        Book result = repo.save(book);

        return Mapper.toBookDto(result);
    }

    @Override
    public BookDto borrowBook(Long id) {
        Book book = repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        Book result = repo.save(book);
        return Mapper.toBookDto(result);
    }

    @Override
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
