package com.matej.draganovski.eimt.controllers;

import com.matej.draganovski.eimt.dtos.BookDto;
import com.matej.draganovski.eimt.requests.CreateBookRequest;
import com.matej.draganovski.eimt.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public Page<BookDto> listBooksPaged(@RequestBody Pageable request) {
        return service.listBooksPaged(request);
    }

    @GetMapping
    public List<BookDto> listBooks() {
        return service.listBooks();
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequest request) {
        return service.createBook(request);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody CreateBookRequest request) {
        return service.updateBook(id, request);
    }

    @GetMapping("/borrow/{id}")
    public BookDto borrowBook(@PathVariable Long id) {
        return service.borrowBook(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);

        return "OK";
    }
}
