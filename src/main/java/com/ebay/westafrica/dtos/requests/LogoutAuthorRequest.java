package com.ebay.westafrica.dtos.requests;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LogoutAuthorRequest {
    private String email;
    private String password;
}
