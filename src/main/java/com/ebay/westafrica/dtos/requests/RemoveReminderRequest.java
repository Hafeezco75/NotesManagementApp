package com.ebay.westafrica.dtos.requests;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RemoveReminderRequest {
    private int reminderId;
    private String reminder;
    private LocalDateTime reminderDate;

}
