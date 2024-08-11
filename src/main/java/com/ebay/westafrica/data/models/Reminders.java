package com.ebay.westafrica.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Getter
@Setter
public class Reminders {
    private LocalDateTime date;
    private String reminderTitle;
    private String reminderDescription;
    private NotesStatus notesStatus;
    private NotesCategory notesCategory;
}
