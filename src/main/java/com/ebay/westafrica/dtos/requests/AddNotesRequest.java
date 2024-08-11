package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.models.NotesCategory;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddNotesRequest {
    private String id;
    private String title;
    private String content;
    private Author author;
    private LocalDate publishDate;
    private NotesCategory category;
}
