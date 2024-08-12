package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Reminders;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.ModifyRemindersRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import com.ebay.westafrica.dtos.responses.ModifyRemindersResponse;
import com.ebay.westafrica.dtos.responses.RemoveReminderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RemindersService {

    AddReminderResponse setReminders(AddReminderRequest addReminderRequest);

    RemoveReminderResponse removeReminder(RemoveReminderRequest reminderRequest);

    ModifyRemindersResponse modifyReminder(ModifyRemindersRequest modifyRemindersRequest);

    List<Reminders> getReminders();
}
