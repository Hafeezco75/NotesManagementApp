package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.ReminderStatus;
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
        Reminders reminders = new Reminders();
        reminders.setTitle("MORNING EXERCISE AND WALK");
        reminders.setDescription("Always push yourself Up everyday and everytime,no one will do it for you");
        reminders.setNotesStatus(ReminderStatus.NEWLYADDED);
        reminders.setDate(LocalDateTime.of(2021, 4, 25, 12, 40));
        remindersRepository.save(reminders);

        AddReminderResponse addReminderResponse = new AddReminderResponse();
        addReminderResponse.setMessage("Successfully added reminder");
        return addReminderResponse;
    }

    @Override
    public RemoveReminderResponse removeReminder(RemoveReminderRequest reminderRequest) {
        RemoveReminderResponse removeReminderResponse =  new RemoveReminderResponse();
        for (Reminders reminders : remindersRepository.findAll()) {
            if (reminders.getTitle().equals(reminderRequest.getTitle())){
                remindersRepository.delete(reminders);
                removeReminderResponse.setMessage("Successfully removed reminder");
                return removeReminderResponse;
            } else {
                throw new IllegalArgumentException("Reminder does not exist");
            }
        }
        return null;
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
