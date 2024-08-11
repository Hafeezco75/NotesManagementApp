package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.NotesStatus;
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
    private String reminderId;
    private String reminderTitle;
    private String reminderDescription;
    private LocalDateTime reminderDate;
    private NotesCategory notesCategory;
    private NotesStatus reminderStatus;
}
