package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.Author;
import com.ebay.westafrica.data.models.NotesCategory;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RemoveNotesRequest {
    private String Title;
    private String Content;
    private Author author;
    private NotesCategory Category;
    private LocalDateTime Date;
}
