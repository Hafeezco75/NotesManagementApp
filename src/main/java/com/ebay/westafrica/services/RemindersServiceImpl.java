package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.Reminders;
import com.ebay.westafrica.data.repositories.RemindersRepository;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.ModifyRemindersRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
import com.ebay.westafrica.dtos.requests.RetrieveAllRemindersRequest;
import com.ebay.westafrica.dtos.responses.AddReminderResponse;
import com.ebay.westafrica.dtos.responses.ModifyRemindersResponse;
import com.ebay.westafrica.dtos.responses.RemoveReminderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RemindersServiceImpl implements RemindersService {
    @Autowired
    RemindersRepository remindersRepository;


    @Override
    public AddReminderResponse setReminders(AddReminderRequest addReminderRequest) {
        AddReminderResponse addReminderResponse = new AddReminderResponse();
        Reminders reminders = new Reminders();
        reminders.setTitle(addReminderRequest.getTitle());
        reminders.setDescription(addReminderRequest.getDescription());
        reminders.setNotesStatus(addReminderRequest.getReminderStatus());
        reminders.setDate(LocalDateTime.of(2021, 4, 25, 12, 40));
        remindersRepository.save(reminders);

        addReminderResponse.setMessage("Successfully added reminder");
        return addReminderResponse;
    }

    @Override
    public RemoveReminderResponse removeReminder(RemoveReminderRequest reminderRequest) {
        RemoveReminderResponse removeReminderResponse =  new RemoveReminderResponse();
            for (Reminders reminder : remindersRepository.findAll()) {
                if (reminder.getTitle().equals(reminderRequest.getTitle())) {
                    if (reminder.getDescription().equals(reminderRequest.getDescription())) {
                        remindersRepository.delete(reminder);
                    }
                }else {
                    throw new IllegalArgumentException("Reminder does not exist");}
            }
        removeReminderResponse.setMessage("Successfully removed reminder");
        return removeReminderResponse;
    }


    @Override
    public ModifyRemindersResponse modifyReminder(ModifyRemindersRequest modifyRemindersRequest){
        ModifyRemindersResponse modifyRemindersResponse = new ModifyRemindersResponse();
        List<Reminders> reminders = remindersRepository.findAll();
            for (Reminders reminder : reminders) {
                if (reminder != null){
                reminder.setTitle(modifyRemindersRequest.getTitle());
                reminder.setDescription(modifyRemindersRequest.getDescription());
                reminder.setDate(modifyRemindersRequest.getDate());
                remindersRepository.save(reminder);
                modifyRemindersResponse.setMessage("Reminder updated successfully");
                return modifyRemindersResponse;
            }else {
                throw new IllegalArgumentException("Reminder does not exist");
            }
        }
            return null;
    }

    @Override
    public List<Reminders> getReminders(RetrieveAllRemindersRequest retrieveAllReminders){
        return remindersRepository.findAll();
    }
}
