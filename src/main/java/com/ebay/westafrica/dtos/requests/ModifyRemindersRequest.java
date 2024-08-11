package com.ebay.westafrica.dtos.requests;

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
}
