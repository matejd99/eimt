package com.matej.draganovski.eimt.requests;

import com.matej.draganovski.eimt.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    private String name;
    private Category category;
    private Integer availableCopies;
    private Long author;
}
