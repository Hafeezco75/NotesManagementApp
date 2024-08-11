package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.ReminderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReminderRequest {
    private String Title;
    private String Description;
    private LocalDateTime reminderDate;
    private NotesCategory notesCategory;
    private ReminderStatus reminderStatus;
}
