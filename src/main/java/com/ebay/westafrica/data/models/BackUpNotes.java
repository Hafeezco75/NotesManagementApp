package com.ebay.westafrica.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BackUpNotes {
    boolean isCreated;
    private String title;
    private String content;
    private Author author;
    private LocalDate publishDate;
}
