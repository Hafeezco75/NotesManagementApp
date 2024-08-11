package com.ebay.westafrica.dtos.requests;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.ReminderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ModifyRemindersRequest {
    private String Title;
    private String Description;
    private LocalDateTime Date;
    private NotesCategory notesCategory;
    private ReminderStatus reminderStatus;
}
