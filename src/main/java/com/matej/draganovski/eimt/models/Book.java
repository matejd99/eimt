package com.matej.draganovski.eimt.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Category category;
    private Integer availableCopies;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
