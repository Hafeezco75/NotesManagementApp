package com.ebay.westafrica.services;

import com.ebay.westafrica.data.models.ReminderStatus;
import com.ebay.westafrica.data.models.Reminders;
import com.ebay.westafrica.data.repositories.RemindersRepository;
import com.ebay.westafrica.dtos.requests.AddReminderRequest;
import com.ebay.westafrica.dtos.requests.ModifyRemindersRequest;
import com.ebay.westafrica.dtos.requests.RemoveReminderRequest;
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
        for (Reminders reminders : remindersRepository.findAll()) {
            if (reminders.getDate().equals(reminderRequest.getReminderDate())) {
                if (reminders.getTitle().equals(reminderRequest.getTitle())) {
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


    @Override
    public ModifyRemindersResponse modifyReminder(ModifyRemindersRequest modifyRemindersRequest){
        for (Reminders reminders : remindersRepository.findAll()) {
            if (reminders.getTitle().equalsIgnoreCase(modifyRemindersRequest.getTitle())){
                reminders.setTitle(modifyRemindersRequest.getTitle());
                reminders.setDescription(modifyRemindersRequest.getDescription());
                reminders.setDate(modifyRemindersRequest.getDate());
                remindersRepository.save(reminders);
                return (ModifyRemindersResponse) remindersRepository;
            }else {
                throw new IllegalArgumentException("Reminder does not exist");
            }
        }

        ModifyRemindersResponse modifyRemindersResponse = new ModifyRemindersResponse();
        modifyRemindersResponse.setMessage("Successfully modified reminder");
        return modifyRemindersResponse;
    }

    @Override
    public List<Reminders> getReminders(){
        return remindersRepository.findAll();
    }
}
