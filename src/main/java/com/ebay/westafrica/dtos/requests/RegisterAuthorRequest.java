package com.ebay.westafrica.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterAuthorRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
