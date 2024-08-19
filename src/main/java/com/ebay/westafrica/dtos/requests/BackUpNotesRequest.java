package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.Author;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BackUpNotesRequest {
    boolean isSuccessful;
    private String title;
    private String content;
    private Author author;
    private LocalDate publishDate;
}
