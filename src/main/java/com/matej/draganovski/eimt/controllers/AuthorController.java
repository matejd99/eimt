package com.matej.draganovski.eimt.controllers;

import com.matej.draganovski.eimt.dtos.AuthorDto;
import com.matej.draganovski.eimt.requests.CreateAuthorRequest;
import com.matej.draganovski.eimt.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService service;


    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<AuthorDto> listAuthors() {
        return service.listAuthors();
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody CreateAuthorRequest request) {
        return service.createAuthor(request);
    }
}
