package com.ebay.westafrica.dtos.requests;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BackUpNotesRequest {
    private String message;
    boolean isSuccessful;
}
