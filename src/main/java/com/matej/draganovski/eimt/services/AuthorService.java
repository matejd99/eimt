package com.matej.draganovski.eimt.services;

import com.matej.draganovski.eimt.dtos.AuthorDto;
import com.matej.draganovski.eimt.requests.CreateAuthorRequest;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> listAuthors();
    AuthorDto createAuthor(CreateAuthorRequest request);
}
