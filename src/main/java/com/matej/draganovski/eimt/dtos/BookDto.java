package com.matej.draganovski.eimt.dtos;

import com.matej.draganovski.eimt.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDto {
    private Long id;
    private String name;
    private Category category;
    private Integer availableCopies;
    private AuthorDto author;
}
