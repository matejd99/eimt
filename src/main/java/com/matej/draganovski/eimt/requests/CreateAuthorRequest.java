package com.matej.draganovski.eimt.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAuthorRequest {
    private String name;
    private String surname;
    private Long country;
}
