package com.matej.draganovski.eimt.mappers;

import com.matej.draganovski.eimt.dtos.AuthorDto;
import com.matej.draganovski.eimt.dtos.BookDto;
import com.matej.draganovski.eimt.dtos.CountryDto;
import com.matej.draganovski.eimt.models.Author;
import com.matej.draganovski.eimt.models.Book;
import com.matej.draganovski.eimt.models.Country;

public class Mapper {
    public static CountryDto toCountryDto(Country country) {
        return new CountryDto(country.getId(), country.getName(), country.getContinent());
    }

    public static AuthorDto toAuthorDto(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getSurname(), toCountryDto(author.getCountry()));
    }

    public static BookDto toBookDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getCategory(), book.getAvailableCopies(), toAuthorDto(book.getAuthor()));
    }
}
