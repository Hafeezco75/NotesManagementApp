package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.NotesCategory;
import com.ebay.westafrica.data.models.NotesStatus;
import com.ebay.westafrica.data.models.Reminders;
import com.ebay.westafrica.data.repositories.RemindersRepository;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import com.ebay.westafrica.dtos.responses.RemoveReminderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RemindersServiceImpl implements RemindersService {
    @Autowired
    RemindersRepository remindersRepository;


    @Override
    public AddReminderResponse setReminders(AddReminderRequest addReminderRequest) {
        Reminders reminders = new Reminders();
        reminders.setReminderTitle("MORNING EXERCISE AND WALK");
        reminders.setReminderDescription("Always push yourself Up everyday and everytime,no one will do it for you");
        reminders.setNotesStatus(NotesStatus.NEWLYADDED);
        reminders.setDate(LocalDateTime.of(2021, 4, 25, 12, 40));
        reminders.setNotesCategory(NotesCategory.DAILYMOTIVATION);
        remindersRepository.save(reminders);

        AddReminderResponse addReminderResponse = new AddReminderResponse();
        addReminderResponse.setMessage("Successfully added reminder");
        return addReminderResponse;
    }

    public RemoveReminderResponse removeReminder(RemoveReminderRequest reminderRequest) {
        for (Reminders reminders : remindersRepository.findAll()) {
            if (reminders.getDate().equals(reminderRequest.getReminderDate())) {
                if (reminders.getReminderTitle().equals(reminderRequest.getReminder())) {
                    remindersRepository.delete(reminders);
                }
            } else {
                throw new IllegalArgumentException("Reminder does not exist");
            }
        }

        RemoveReminderResponse removeReminderResponse = new RemoveReminderResponse();
        removeReminderResponse.setMessage("Successfully removed reminder");
        return removeReminderResponse;
    }

}
