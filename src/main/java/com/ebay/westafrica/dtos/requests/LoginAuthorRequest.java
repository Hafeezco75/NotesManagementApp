package com.ebay.westafrica.dtos.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginAuthorRequest {
    private String email;
    private String password;
}
