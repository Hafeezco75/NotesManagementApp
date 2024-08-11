package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.ReminderStatus;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RemoveReminderRequest {
    private String Title;
    private String Description;
    private LocalDateTime reminderDate;
    private NotesCategory notesCategory;
    private ReminderStatus reminderStatus;

}
