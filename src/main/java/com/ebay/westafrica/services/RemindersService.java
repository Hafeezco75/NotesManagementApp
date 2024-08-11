package com.ebay.westafrica.services;

import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface RemindersService {

    @Autowired
    AddReminderResponse setReminders(AddReminderRequest addReminderRequest);
}
