package com.ebay.westafrica.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notes {
    @Id
    private String id;
    private String Title;
    private String Content;
    private Author author;
    private LocalDateTime Date;

}
