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
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
