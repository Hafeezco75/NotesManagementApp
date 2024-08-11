package com.ebay.westafrica.dtos.requests;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveAllNotesRequest {
    private String notesId;
    private String Title;
    private String Content;
    private String Author;
    private LocalDateTime Date;
}
