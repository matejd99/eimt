package com.matej.draganovski.eimt.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CountryDto {
    private Long id;
    private String name;
    private String continent;
}
